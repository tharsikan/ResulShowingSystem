import React,{useState,useEffect} from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import axios from 'axios'
import CustomizedTables from './CustomizedTables';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <Typography
      component="div"
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && <Box p={3}>{children}</Box>}
    </Typography>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
}));

export default function SimpleTabs(props) {
  const {degreeId} = props;
  const [levels,setLevels] = useState([]);

  useEffect(()=>{
    axios.get('http://localhost:8012/degreeProgram/'+degreeId+'/level')
        .then(response=>{
          setLevels(response.data)
          console.log(response.data)
            })
        .catch(error=>{
                console.log(error)
            })
  },[])


  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
    console.log(newValue);
  };

  const [indx,setIndx] = useState(0);
  const selectLevel = (levelId)=>{
    console.log(levelId)
    setIndx(levelId)
  }

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Tabs value={value} onChange={handleChange} aria-label="simple tabs example">
          {/* <Tab label="Item One" {...a11yProps(0)} />
          <Tab label="Item Two" {...a11yProps(1)} />
          <Tab label="Item Three" {...a11yProps(2)} />
          <Tab label="Item Three" {...a11yProps(4)} /> */}
          {
                levels.map((level,num)=>(
                    <Tab label={level.level} {...a11yProps(level.id)} onClick={()=>selectLevel(level.id)}/>
                ))
            }
        </Tabs>   
      </AppBar>

      <TabPanel value={value} index={0}>
        <CustomizedTables levelId={indx}/>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <CustomizedTables levelId={indx}/>
      </TabPanel>
      <TabPanel value={value} index={2}>
        <CustomizedTables levelId={indx}/>
      </TabPanel>
      <TabPanel value={value} index={3}>
        <CustomizedTables levelId={indx}/>
      </TabPanel>
    </div>
  );
}