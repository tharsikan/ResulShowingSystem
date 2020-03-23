import React,{useState,useEffect} from 'react';
import axios from 'axios'
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Select from '@material-ui/core/Select';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { makeStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel'; 
import MenuItem from '@material-ui/core/MenuItem';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormLabel from '@material-ui/core/FormLabel';


const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

function StudentForm() {
  const classes = useStyles();
  let [batchs, setBatchs] = useState([]);
  let [degrees, setDegrees] = useState([]);
  let [levels, setLevels] = useState([]);
  let [levelShow, setLevelShow] = useState(true);
  let [addNumber, setAddNumber] = useState(false);
  let [degreesShow, setDegreesShow] = useState(true);
  let [course, setCourse]  = useState({
      batchId:"",
      degreeProgramId:"",
      levelId:"",
      indexNo:"",
	    registration:"",
	    firstName:"",
	    lastName:"",
	    gender:"",
	    subjectCombination:"",
	    nicNo:"",
	    dateOfBirth:"",
	    telephoneList:[],
	    address :{
		    houseNo:"",
    	  lane:"",
    	  city:"",
	    },
	    email:""
  });
  const [phone1,setPhone1] = useState('');
  const [phone2,setPhone2] = useState('');
    useEffect(()=>{
        axios.get('http://localhost:8012/batch')
            .then(response=>{
                setBatchs(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
    },[])

  let selectBatch = (e) => {
    setCourse({...course, batchId: e.target.value})
    setDegreesShow(false)
    axios.get('http://localhost:8012/batch/'+e.target.value+'/degreeProgram')
            .then(response=>{
                setDegrees(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  let selectDegree = (e) => {
    setCourse({...course, degreeProgramId: e.target.value})
    setLevelShow(false)
    axios.get('http://localhost:8012/degreeProgram/'+e.target.value+'/level')
            .then(response=>{
                setLevels(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  let selectLevel = (e) => {
    setCourse({...course, levelId: e.target.value})
    console.log(course)
  }


  let changeHandil = (e) =>{
    setCourse({...course, [e.target.name] : e.target.value})
  }
  let addressHandil = (e) =>{
    setCourse({...course, address:{...course.address,[e.target.name]: e.target.value}})
  }

  let telephoneList1Handil = () =>{
    setCourse({...course, telephoneList: [course.telephoneList[0]={number: phone1},course.telephoneList[1]={number: phone2}]  })
  }

  let phone1Handil = (e) =>{
    setPhone1(e.target.value)
  }
  let phone2Handil = (e) =>{
    setPhone2(e.target.value)
  }


  let submitHandil = (e) =>{
    telephoneList1Handil();
    e.preventDefault()
    // console.log(course)
    axios.post('http://localhost:8011/student',course)
            .then(response=>{
                console.log(response)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  return (
    <Container component="main" maxWidth="xs" onSubmit={submitHandil}>
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          {/* <LockOutlinedIcon /> */}
        </Avatar>
        <Typography component="h1" variant="h5">
          Regeister Studnet
        </Typography>
        <form className={classes.form} noValidate>
        <FormControl variant="outlined" margin="normal" required fullWidth autoFocus>
            <InputLabel for="lavel">Batch</InputLabel>
            <Select onChange={selectBatch}>
              {
              batchs.map(batch=>(
                        <MenuItem value={batch.id}>{batch.batchId}</MenuItem>
                    ))
              }
            </Select>
      </FormControl>
      <FormControl variant="outlined" margin="normal" required fullWidth disabled={degreesShow}>
            <InputLabel >Degree Program</InputLabel>
            <Select onChange={selectDegree}>
              {
              degrees.map(degree=>(
                        <MenuItem value={degree.id}>{degree.degreeProgram}</MenuItem>
                    ))
              }
            </Select>
            {degreesShow && <FormHelperText>Disabled</FormHelperText>}
      </FormControl>
      <FormControl variant="outlined" margin="normal" required fullWidth disabled={levelShow}>
            <InputLabel>Level</InputLabel>
            <Select onChange={selectLevel}>
              {
              levels.map(level=>(
                        <MenuItem value={level.id}>{level.level}</MenuItem>
                    ))
              }
            </Select>
            {levelShow && <FormHelperText>Disabled</FormHelperText>}
      </FormControl>
          <TextField variant="outlined" margin="normal" required fullWidth label="Index No"
           name="indexNo" value={course.indexNo} onChange={changeHandil}/>
          <TextField variant="outlined" margin="normal" required fullWidth label="Registration No"
           name="registration" value={course.registration} onChange={changeHandil}/>
          <FormControl  margin="normal" required fullWidth >
            <FormLabel >Gender</FormLabel>
            <RadioGroup aria-label="gender" name="gender" value={course.gender} onChange={changeHandil} class="form-group form-inline">
              <FormControlLabel value="female" control={<Radio />} label="Female" labelPlacement="start" />
              <FormControlLabel value="male" control={<Radio />} label="Male" labelPlacement="start"/>
            </RadioGroup>
          </FormControl>
          <TextField variant="outlined" margin="normal" required fullWidth label="First Name"
           name="firstName" value={course.firstName} onChange={changeHandil}/>
          <TextField variant="outlined" margin="normal" required fullWidth label="Last Name"
           name="lastName" value={course.lastName} onChange={changeHandil}/>
          <TextField variant="outlined" margin="normal" required fullWidth label="Subject Combination"
           name="subjectCombination" value={course.subjectCombination} onChange={changeHandil}/>
          <TextField variant="outlined" margin="normal" required fullWidth label="Nic No"
           name="nicNo" value={course.nicNo} onChange={changeHandil}/>
          <TextField variant="outlined" margin="normal" required fullWidth label="Date Of Birth"
           name="dateOfBirth" value={course.dateOfBirth} onChange={changeHandil}/>
            <TextField variant="outlined" margin="normal" required style={{ width: "50%" }} label="Phone Number"
            name="telephoneList[]" value={phone1} onChange={phone1Handil}/>
            {addNumber ?  <TextField variant="outlined" margin="normal" required style={{ width: "50%" }} label="Phone Number"
            name="telephoneList[]" value={phone2} onChange={phone2Handil}></TextField>: ''}
            {addNumber ? '' : <Button variant="outlined" color="secondary"  onClick={()=>setAddNumber(true)}>+</Button>}
          <TextField variant="outlined" margin="normal" required fullWidth label="Email"
           name="email" value={course.email} onChange={changeHandil}/>  
            
            <FormLabel class="form-group form-inline">
            <TextField variant="outlined" margin="normal" size='small' label="houseNo" style={{ width: "33%" }}
             name="houseNo" value={course.address.houseNo} onChange={addressHandil}/>
            <TextField variant="outlined" margin="normal" size='small' label="lane" style={{ width: "33%" }}
              name="lane" value={course.address.lane} onChange={addressHandil}/>
            <TextField variant="outlined" margin="normal" size='small' label="city" style={{ width: "33%" }}
             name="city" value={course.address.city} onChange={addressHandil}/>
           </FormLabel>
        
          <Button type="submit" fullWidth variant="contained" color="primary" className={classes.submit}>SUBMIT</Button>
        </form>
      </div>
    </Container>
  );

};
export default StudentForm
