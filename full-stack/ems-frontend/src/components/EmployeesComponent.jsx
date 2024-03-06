import React, { useState } from 'react'

const EmployeesComponent = () => {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');

  function saveEmployee(e){
    e.preventDefault();
    
    const employee = {firstName, lastName, email}
    console.log(employee)
  }

  return (
    <div className='container'>
      <br /><br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          <h2 className='text-center'>Add Employee</h2>
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'>Employee First Name:</label>
                <input
                  type='text'
                  placeholder='Enter Employee First Name'
                  name='firstName'
                  value={firstName}
                  className='form-control'
                  onChange={(e) => {setFirstName(e.target.value);}}
                >
                </input>
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Employee Last Name:</label>
                <input
                  type='text'
                  placeholder='Enter Employee Last Name'
                  name='lastName'
                  value={lastName}
                  className='form-control'
                  onChange={(e) => {setLastName(e.target.value);}}
                >
                </input>
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Employee Email:</label>
                <input
                  type='email'
                  placeholder='Enter Employee Email'
                  name='email'
                  value={email}
                  className='form-control'
                  onChange={(e) => {setEmail(e.target.value);}}
                >
                </input>

                <button className='btn btn-success' onClick={saveEmployee}>Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default EmployeesComponent