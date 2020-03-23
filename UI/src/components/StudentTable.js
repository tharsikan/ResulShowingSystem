import React,{useState} from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

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

function createData(title, data) {
  return {title, data };
}
const rows = [
  createData('Current Level', ''),
  createData('Batch No: ', ''),
  createData('Index No: ', 'Introduction'),
  createData('Registration No: ', 'Mathematics for Computing I'),
  createData('Full Name: ',''), 
  createData('Gender: ', ''),
  createData('Degree Program: ', 'Data'), 
  createData('Subject Combination: ', 'Data'),
  createData('NIC No: ', 'Data'),
  createData('Date of Birth: ', 'Data'),
  createData('Date of Admission: ', 'Data'), 
  createData('Permanent Address: ', 'Data'), 
  createData('Temporary Address: ', 'Data'), 
  createData('Mobile No: ', 'Data'), 
  createData('E-Mail: ', 'Data'), 
];

const useStyles = makeStyles({
  table: {
    maxWidth: 395,
  },
});

export default function StudentTable() {
  const classes = useStyles();

  const [count,setCount] = useState(0);

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell>S 9014</StyledTableCell>
            <StyledTableCell>tharsikan</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => (
            <StyledTableRow key={row.data}>
              <StyledTableCell component="th" scope="row">
                {row.title}
              </StyledTableCell>
              <StyledTableCell align="right">{row.data}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
      <button onClick={() => setCount(prevCount => prevCount+1)}>row {count}</button>
    </TableContainer>
  );
}