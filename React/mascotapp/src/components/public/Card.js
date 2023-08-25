import React from 'react'
import {Link} from "react-router-dom"
export const  Card = ({mascota}) => {
  return (
    <div className="col">
        <div className="card shadow-sm">
          <img className="bd-placeholder-img card-img-top" width="100%" height="225"  src={mascota.image} alt="Img rick and morty"></img>
           <h3 className="mb-0 text-dark" > {mascota.name}</h3> 


          <div className="card-body">
            <p className="card-text"></p>
            <div className="d-flex justify-content-between align-items-center">
              <div className="btn-group">
                <Link to={`/detail/${mascota.id}`} className="nav-link px-2 text-secondary">Detalle</Link>
                
              </div>
              <small className="text-body-secondary">{new Date(mascota.createdAt).toLocaleDateString}</small>
            </div>
          </div>
        </div>
      </div>
  )
}

export default Card
