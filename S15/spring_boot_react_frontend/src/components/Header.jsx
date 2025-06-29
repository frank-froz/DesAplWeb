const Header = () => {
    return ( 
        <header>
            <nav className="navbar navbar-expand-lg bg-body-tertiary">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Empleados</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                        <a className="nav-link active" aria-current="page" href="#">Lista</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Añadir</a>
                        </li>
                    </ul>
                    </div>
                </div>
                </nav>
        </header>
     );
}
 
export default Header;