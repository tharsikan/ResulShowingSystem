import React from 'react';
import logo from './logo.svg';
import './App.css';
import StudentList from './components/StudentList';
import SignIn from './components/SignIn';
import Dashboard from './components/Dashboard';
function App() {
  return (
    <div className="App">

      {/* <StudentList/> */}

      <Dashboard/>
      {/* <SignIn/> */}
    </div>
  );
}

export default App;
