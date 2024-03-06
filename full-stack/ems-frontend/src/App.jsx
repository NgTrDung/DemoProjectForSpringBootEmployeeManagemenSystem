import './App.css'
import EmployeesComponent from './components/EmployeesComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponents from './components/HeaderComponents'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponents />
        <Routes>
          {/* // http://localhost:8081 */}
          <Route path='/' element={<ListEmployeeComponent />}></Route>
          {/* // http://localhost:8081/employees */}
          <Route path='/employees' element={<ListEmployeeComponent />}></Route>
          {/* // http://localhost:8081/add-employee */}
          <Route path='/add-employee' element={<EmployeesComponent />}></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
