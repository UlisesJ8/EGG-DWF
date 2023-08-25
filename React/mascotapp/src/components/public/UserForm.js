import React, { useEffect, useState } from 'react'
import { useUserForm } from '../../hooks/Custom.hooks';

const UserForm = () => {

    const{form, handleChanges } = useUserForm();
    const[areEquals, setAreEquals] = useState(true)
    const[passwordConfirmation, setPasswordConfirmation] = useState(true)

    const handlePasswordConfirmation = (e) =>{
        setPasswordConfirmation(e.target.value)

    }

    useEffect((e) => {

        const {password} = form;
        setAreEquals( password === passwordConfirmation)
    },[passwordConfirmation])


    const handleSubmit = (e) => {
    e.preventDefault();
    
    console.log(form);

    }


  return (
    <div className="w-25 mx-auto mt-5">
        <h4 className="mb-3">Humano Registrate! </h4>
    
    <form className="needs-validation" noValidate>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email </label>
    <input type="email" 
    class="form-control" 
    id="exampleInputEmail1" 
    aria-describedby="emailHelp" 
    placeholder='you@example.com'
     name="email"
     onChange={handleChanges}
     />
    
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Clave</label>
    <input type="password" 
    class="form-control" 
    id="exampleInputPassword1"
    name="password"
    onChange={handleChanges}
    />
  </div>
  <div class="mb-3 ">
    <label for="exampleInputPassword1" class="form-label">Repetir Clave</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Repetir clave" onChange={handlePasswordConfirmation}/>
  </div>
  { !areEquals&&(
        <div className="form-text list-group-item-danger">
            Las claves no son iguales.
        </div>
    )}
  <button disabled={!areEquals} type="submit" class="btn btn-primary" onClick={handleSubmit}>Registrarme</button>
</form>
    </div>
  )
}

export default UserForm
