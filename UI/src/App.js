import React from 'react';
import logo from './logo.svg';
import './App.css';
// import StudentList from './components/StudentList';
import SignIn from './components/SignIn';
import Dashboard from './components/Dashboard';
// import MyList from './components/MyList';
import CourseForm from './components/CourseForm';
import StudentForm from './studentComponent/studentForm'
import UseReducerExample from './studentComponent/useReducerExample'
import {BrowserRouter as Router , Route, Switch, Redirect, Link, withRouter} from 'react-router-dom'
import NavBar from './components/NavBar'

const fakeAuth = {
  isAuthenticated: false,
  authenticate(cb){
    this.isAuthenticated = true
    setTimeout(cb, 100) // fake async
  },
  signout(cb){
    this.isAuthenticated = false
    setTimeout(cb, 100) // fake async
  }
}

const Public = () => <h3>Public</h3>
const Protected = () => <h3>Protected</h3>

class Login extends React.Component{
  state ={
    redictToReferrer: false
  }
  login = () =>{
    fakeAuth.authenticate(()=>{

      this.setState(() => ({
        redictToReferrer: true
      }))
    })
  }
  
  render(){
    const {redictToReferrer} = this.state
    const {from} = this.props.location.state || {from: { pathname: '/'}}  // routed from were ??? 
    if(redictToReferrer === true){
      return(
        <Redirect to='/' />
      )
    }

    return(
      <div>
        <p>you must log in to see this page at {from.pathname} url </p>
        <button onClick={this.login}>Log in</button>
      </div>
    )
  }
}

const PrivateRoute = ({ component: Component, ...rest }) =>(
  <Route {...rest} render={(props) => (
    fakeAuth.isAuthenticated === true
    ? <Component {...props} />
    // : <Redirect to='/login' /> not just login after login you shoud go to protected page
    : <Redirect to={{
        pathname: '/login',
        state: { from: props.location }    
    }} />
  )} />
)
const AuthButton = withRouter(({history}) => (
    fakeAuth.isAuthenticated === true 
    ? <p>Welcome!! <button onClick={()=>{
      fakeAuth.signout(()=>history.push('/'))
    }}>Sign Out</button></p> 
    : <p>You are not Logged in</p>
))

function App() {
  return (
    <Router>
      {/* <a href={'http://localhost:8080'}>click</a> */}
    {/* <div className="App"> */}
      {/* <SignIn/> */}
      {/* <StudentList/> */}
      {/* <Dashboard/> */}
      {/* <MyList/> */}
      {/* <CourseForm/> */}
      {/* <StudentForm/> */}
      {/* <UseReducerExample/> */} 
    {/* </div> */}
      <div className="App">
        {/* <NavBar/> */}
        {/* navBar   */}
        <Switch>
          <Route path="/" exact component={SignIn}/>
          {/* <Route path="login" component={SignIn}/> */}
          <Route path="/home" component={Dashboard}/>
          <Route path="/add_student" component={StudentForm}/>
          <Route path="/add_course" component={CourseForm}/>
          
        </Switch>

        <AuthButton/>
        <ul>
          <li><Link to='/public'>public page</Link></li>
          <li><Link to='/protected'>protected page</Link></li>
        </ul>
        <Route path="/public" component={Public}/>
        <Route path="/login" component={Login}/>

        <PrivateRoute path="/protected" component={Protected} />
        {/* <Route path='/privacy-policy' component={() => { 
            window.location.href = 'https://localhost:8080'; 
            return null;
        }}/> */}
      </div>
      </Router>
    
  );
}

export default App;
