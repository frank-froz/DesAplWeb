import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const Empleado = () => {
    const [empleados, setEmpleados] = useState([]);
    const navigate = useNavigate();


    useEffect(() => {
        cargarEmpleados();
    }, []);

    const cargarEmpleados = async () => {
        try {
            const res = await axios.get(`http://localhost:8080/api/v1/empleados`);
            setEmpleados(res.data);
        } catch (error) {
            console.error("Error al cargar empleados:", error);
        }
    };

    const eliminarEmpleado = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/v1/empleados/${id}`);
            await cargarEmpleados();
            toast.success("Empleado eliminado correctamente");
        } catch (error) {
            console.error("Error al eliminar empleado:", error);
            toast.error("Error al eliminar empleado");
        }
    };

    return ( 
        <div className="container mt-4">
            <h2>Lista de empleados</h2>
            <button onClick={() => navigate("/add")} className="btn btn-success mb-2">
                Nuevo Empleado
            </button>
            <table className="table table-bordered">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {empleados.map((emp) => (
                        <tr key={emp.id}>
                            <td>{emp.nombre}</td>
                            <td>{emp.apellido}</td>
                            <td>{emp.email}</td>
                            <td>
                                <button
                                    onClick={() => navigate(`/edit/${emp.id}`)}
                                    className="btn btn-warning btn-sm me-2"
                                >
                                    Editar
                                </button>
                                <button
                                    onClick={() => eliminarEmpleado(emp.id)}
                                    className="btn btn-danger btn-sm"
                                >
                                    Eliminar
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
     );
}
 
export default Empleado;