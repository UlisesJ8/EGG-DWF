import React from 'react'
import {Link} from "react-router-dom"
const NavBar = () => {
  return (
    <div>
      <header className="p-3 text-bg-dark">
    <div className="container">
      <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
       
       <span className="d-flex aling-items-center mb-2 mg-lg-0 text-white text-decoration-none">
        <img className="App-logo" width="50%" src="Puppy.png" alt="Perro girando"></img>

       </span>

        <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><Link to="/" className="nav-link px-2 text-secondary">Home</Link></li>
          <li><Link to="/user-form" className="nav-link px-2 text-secondary">Formulario</Link></li>
          <li><Link to={"/details/:id"} className="nav-link px-2 text-secondary">Detalle</Link></li>
        </ul>

        <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" className="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search"/>
        </form>

        <div className="text-end">
         
          <Link to="user-form" type="button" className="btn btn-warning">Registrate</Link>
        </div>
      </div>
    </div>
  </header>

    </div>
  )
}

export default NavBar
