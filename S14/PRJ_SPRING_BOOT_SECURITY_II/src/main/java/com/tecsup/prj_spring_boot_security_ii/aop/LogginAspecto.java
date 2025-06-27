package com.tecsup.prj_spring_boot_security_ii.aop;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.AuditableEntity;
import com.tecsup.prj_spring_boot_security_ii.domain.entities.Auditoria;
import com.tecsup.prj_spring_boot_security_ii.domain.persistance.AuditoriaDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;

@Component
@Aspect
public class LogginAspecto {

    private Long tx;

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Around("execution(* com.tecsup.prj_spring_boot_security_ii.services.*ServiceImpl.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result =  null;
        Long currTime = System.currentTimeMillis();
        tx = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = "tx[" + tx + "] - " + joinPoint.getSignature().getName();
        //logger.info(metodo + "()");
        if(joinPoint.getArgs().length > 0)
            logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error(e.getMessage());
        }
        logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
        return result;
    }

    @After("execution(* com.tecsup.demo.controllers.*Controller.guardar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.*Controller.editar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.*Controller.eliminar*(..))")
    public void auditoria(JoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = joinPoint.getSignature().getName();
        Integer id = null;
        String tabla = "desconocido";

        Object[] parametros = joinPoint.getArgs();

        if (metodo.startsWith("guardar")) {
            if (parametros[0] instanceof AuditableEntity entity) {
                id = entity.getId();
                tabla = entity.getNombreTabla();
            } else {
                logger.error("No es una entidad auditable: " + parametros[0].getClass());
                return;
            }
        } else if (metodo.startsWith("editar") || metodo.startsWith("eliminar")) {
            id = (Integer) parametros[0];
            // En estos casos necesitas obtener el nombre de la tabla desde otro lugar o usar una convención
            // Por ejemplo: obtenerlo por reflexión si el método está en AlumnoController o CursoController
            String controllerName = joinPoint.getTarget().getClass().getSimpleName().toLowerCase();
            if (controllerName.contains("alumno")) {
                tabla = "alumnos";
            } else if (controllerName.contains("curso")) {
                tabla = "cursos";
            }
        }

        String traza = "tx[" + tx + "] - " + metodo;
        logger.info(traza + "(): registrando auditoria...");

        auditoriaDao.save(new Auditoria(tabla, id, Calendar.getInstance().getTime(), "usuario", metodo));
    }

}

