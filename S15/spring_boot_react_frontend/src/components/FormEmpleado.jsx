import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

const FormEmpleado = () => {
    const [empleado, setEmpleado] = useState({
        nombre: "",
        apellido: "",
        email: ""
    });

    const { id } = useParams(); 
    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            cargarEmpleado();
        }
    }, [id]);

    const cargarEmpleado = async () => {
        try {
            const res = await axios.get(`http://localhost:8080/api/v1/empleados/${id}`);
            setEmpleado(res.data);
        } catch (error) {
            console.error("Error al cargar empleado", error);
        }
    };

    const handleChange = (e) => {
        setEmpleado({ ...empleado, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if (id) {
                await axios.put(`http://localhost:8080/api/v1/empleados/${id}`, empleado);
            } else {
                await axios.post(`http://localhost:8080/api/v1/empleados`, empleado);
            }
            navigate("/");
        } catch (error) {
            console.error("Error al guardar empleado", error);
        }
    };

    return (
        <div className="container mt-4">
            <h2>{id ? "Editar Empleado" : "Nuevo Empleado"}</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Nombre</label>
                    <input
                        type="text"
                        className="form-control"
                        name="nombre"
                        value={empleado.nombre}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Apellido</label>
                    <input
                        type="text"
                        className="form-control"
                        name="apellido"
                        value={empleado.apellido}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        name="email"
                        value={empleado.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary me-2">
                    {id ? "Actualizar" : "Guardar"}
                </button>
                <button type="button" className="btn btn-secondary" onClick={() => navigate("/")}>
                    Cancelar
                </button>
            </form>
        </div>
    );
};

export default FormEmpleado;
