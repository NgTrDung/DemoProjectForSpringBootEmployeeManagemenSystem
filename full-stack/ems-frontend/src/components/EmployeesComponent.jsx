import React, { useEffect, useState } from 'react';
import { createEmployee, getEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeesComponent = () => {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');

  const navigator = useNavigate();
  const { id } = useParams();

  const [errors, setErrors] = useState({
    firstName: '',
    lastName: '',
    email: ''
  })

  function saveEmployee(e) {
    e.preventDefault();

    if (validateForm()) {
      const employee = { firstName, lastName, email }
      console.log(employee)

      createEmployee(employee).then((respone) => {
        console.log(respone.data);
        navigator('/employees')
      })
    }
  }

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors }
    if (firstName.trim()) {
      errorsCopy.firstName = '';
    }
    else {
      errorsCopy.firstName = 'First name is required';
      valid = false;
    }

    if (lastName.trim()) {
      errorsCopy.lastName = '';
    }
    else {
      errorsCopy.lastName = 'Last name is required';
      valid = false;
    }

    if (email.trim()) {
      errorsCopy.email = '';
    }
    else {
      errorsCopy.email = 'Email is required';
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className='text-center'>Update Employee</h2>
    }
    else {
      return <h2 className='text-center'>Add Employee</h2>
    }
  }

  useEffect(() => {
    if (id) {
      getEmployee(id).then((response) => {
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
      }).catch(error => {
        console.error(error);
      })
    }
  }, [id])

  return (
    <div className='container'>
      <br /><br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          {
            pageTitle()
          }
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'>Employee First Name:</label>
                <input
                  type='text'
                  placeholder='Enter Employee First Name'
                  name='firstName'
                  value={firstName}
                  className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                  onChange={(e) => { setFirstName(e.target.value) }}
                >
                </input>
                {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Employee Last Name:</label>
                <input
                  type='text'
                  placeholder='Enter Employee Last Name'
                  name='lastName'
                  value={lastName}
                  className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                  onChange={(e) => { setLastName(e.target.value) }}
                >
                </input>
                {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Employee Email:</label>
                <input
                  type='email'
                  placeholder='Enter Employee Email'
                  name='email'
                  value={email}
                  className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                  onChange={(e) => { setEmail(e.target.value) }}
                >
                </input>
                {errors.email && <div className='invalid-feedback'>{errors.email}</div>}

                <button className='btn btn-success mt-3' onClick={saveEmployee}>Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default EmployeesComponent