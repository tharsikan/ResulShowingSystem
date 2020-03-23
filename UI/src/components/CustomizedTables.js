import React,{useState,useEffect} from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import axios from 'axios'

const StyledTableCell = withStyles(theme => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const StyledTableRow = withStyles(theme => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.background.default,
    },
  },
}))(TableRow);

function createData(courseCode, courseTitle, grade, academicYear, earnedGpv, previousResults) {
  return {courseCode, courseTitle, grade, academicYear, earnedGpv, previousResults };
}
  const rows = [
    createData('CSC111SC3', 'Foundations of Computer Science', 'C', '2014', '4.00', 'D(2016)'),
    createData('CSC112SC3', 'Computer Programming I', 'C+', '2014', '4.00', 'D(2016)'),
    createData('CSC113SC2', 'Introduction to Computer Security and Cryptography', 'C', '2017', '4.00', 'D(2016)'),
    createData('CSC114SC2', 'Mathematics for Computing I', 'B', '2017', '4.00', ),
    createData('CSC115SC3', 'Statistics for Computing-I', 'B', '2017', '4.00', 'D(2016)'),
    createData('CSC116SC2', 'Introduction to Computer Systems', 'C', '2014', '4.00', 'D(2016)'),
    createData('CSC117SC2', 'Data Structures and Algorithms-I', 'C', '2017', '4.00', 'C(2015), E(2014)'),
  ];

const useStyles = makeStyles({
  table: {
    minWidth: 700,
  },
});

export default function CustomizedTables(props) {
  const classes = useStyles();
  const {levelId} =props;
  const [course,setCourse] = useState();
  const [count,setCount] = useState(0);
  useEffect(()=>{
    axios.get('http://localhost:8012/level/'+levelId+'/course')
        .then(response=>{
          console.log(response.data,"ooooooooooooooolllllllllllllll")
          setCourse(response.data)
            })
        .catch(error=>{
                console.log(error)
            })
},[])
  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell>Course Code</StyledTableCell>
            <StyledTableCell align="right">Course Title</StyledTableCell>
            <StyledTableCell align="right">Grade&nbsp;</StyledTableCell>
            <StyledTableCell align="right">Academic Year</StyledTableCell>
            <StyledTableCell align="right">Earned GPV</StyledTableCell>
            <StyledTableCell align="right">Previous Results</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {
            course != null ?
                course.map(course=>(
                  <StyledTableRow key={course.courseCode}>
                    <StyledTableCell component="th" scope="course">
                      {course.courseCode}
                    </StyledTableCell>
                    <StyledTableCell align="right">{course.courseTitle}</StyledTableCell>
                    <StyledTableCell align="right">{course.grade}</StyledTableCell>
                    <StyledTableCell align="right">{course.academicYear}</StyledTableCell>
                    <StyledTableCell align="right">{course.earnedGpv}</StyledTableCell>
                    <StyledTableCell align="right">{course.previousResults}</StyledTableCell>
                  </StyledTableRow>
                )):console.log("no-data")
            }


          {/* {course.map(row => (
            <StyledTableRow key={row.courseCode}>
              <StyledTableCell component="th" scope="row">
                {row.courseCode}
              </StyledTableCell>
              <StyledTableCell align="right">{row.courseTitle}</StyledTableCell>
              <StyledTableCell align="right">{row.grade}</StyledTableCell>
              <StyledTableCell align="right">{row.academicYear}</StyledTableCell>
              <StyledTableCell align="right">{row.earnedGpv}</StyledTableCell>
              <StyledTableCell align="right">{row.previousResults}</StyledTableCell>
            </StyledTableRow>
          ))} */}
        </TableBody>
      </Table>
      <button onClick={() => setCount(prevCount => prevCount+1)}>row {count}</button>
    </TableContainer>
  );
}