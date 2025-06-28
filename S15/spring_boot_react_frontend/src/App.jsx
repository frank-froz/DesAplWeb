import { BrowserRouter, Routes, Route } from "react-router-dom"
import Header from "./components/Header"
import Empleado from "./components/Empleado"
import FormEmpleado from "./components/FormEmpleado"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {

  return (
    <>
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Empleado />} />
          <Route path="/add" element={<FormEmpleado />} />
          <Route path="/edit/:id" element={<FormEmpleado />} />
        </Routes>
      </BrowserRouter>
      <ToastContainer position="top-right" autoClose={2000} />
    </>
  )
}

export default App
