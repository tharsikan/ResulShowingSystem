import React from 'react';
import logo from './logo.svg';
import './App.css';
import StudentList from './components/StudentList';
import SignIn from './components/SignIn';
import Dashboard from './components/Dashboard';
import MyList from './components/MyList';
import CourseForm from './components/CourseForm';
import StudentForm from './studentComponent/studentForm'
import UseReducerExample from './studentComponent/useReducerExample'

function App() {
  return (
    <div className="App">

      {/* <StudentList/> */}
      {/* <Dashboard/> */}
      {/* <MyList/> */}
      {/* <CourseForm/> */}
      <StudentForm/>
      <UseReducerExample/>
    </div>
  );
}

export default App;
