import React, { useState } from 'react'

export const Footer = () => {

  const [clicks, setClicks] = useState(0);

  const year = new Date().getFullYear();
  const companyName = " Egg education"

  const handleClick = () => {
    setClicks(clicks +1);

  }

  return (
    <div className="container">
    <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <p className="col-md-4 mb-0 text-body-secondary">&copy; {year} {companyName} Clicks={clicks}</p>
    <span className="d-flex aling-items-center mb-2 mg-lg-0 text-white text-decoration-none"
    onClick={handleClick}
    >
    <img className="App-logo" width="50%" src="Puppy.png" alt="Perro girando"></img>

   </span>

<ul className="nav col-md-4 justify-content-end">
  <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Home</a></li>
  <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Features</a></li>
  <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Pricing</a></li>
  <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">FAQs</a></li>
  <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">About</a></li>
</ul>
</footer>
</div>
    
  )
}

