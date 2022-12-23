import React, { useEffect, useState } from 'react';
import axios from 'axios';

import AnimatedText from 'react-animated-text-content';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { pink } from '@mui/material/colors';
import { grey } from '@mui/material/colors';
import { red } from '@mui/material/colors';
import Zoom from '@mui/material/Zoom';
import { Link } from '@reach/router';

const useStyles = makeStyles({
    table: {
      minWidth: 300,
    },
  });

const AuthorDisplay = (props) => {
    const [authors, setAuthors] = useState([])

    useEffect(()=>{
        axios.get('http://localhost:8000/api/auther')
        .then(res => setAuthors(res.data));
    },[])
    const classes = useStyles();
  return (

    <div style={{width:"50%" , margin:"0 auto", marginTop:"7%"}}>
                  <AnimatedText
  type="chars" // animate words or chars
  animation={{
    x: '200px',
    y: '-20px',
    scale: 1.1,
    ease: 'ease-in-out',
  }}
  animationType="bounce"
  interval={0.06}
  duration={0.8}
  tag="h1"
  className="animated-paragraph"
  includeWhiteSpaces
  threshold={0.1}
  rootMargin="20%"
  style={{color: pink[900]}}
>
  Favorite Author
</AnimatedText>
  <AnimatedText
  type="chars" // animate words or chars
  animation={{
    x: '200px',
    y: '-20px',
    scale: 1.5,
    ease: 'ease-in-out',
  }}
  animationType="lights"
  interval={0.1}
  duration={0.8}
  tag="p"
  className="animated-paragraph"
  includeWhiteSpaces
  threshold={0.1}
  rootMargin="20%"
  style={{color: pink[400]}}
>
  We Have Quotes By:
</AnimatedText>

        <p>
            <Link style={{color : pink[900]}} to={"/new"}>
                Add new Author
            </Link>
        </p>
        <Zoom in="true" >
      <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">  
        <TableHead>
          <TableRow>
            <TableCell style={{ backgroundColor: pink[500] , color:grey[50]}} >Name</TableCell>
            <TableCell style={{ backgroundColor: pink[500], color:grey[50] }} align="right">Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {authors.map((auth , idx) => (
            <TableRow  key={idx}>
              <TableCell style={{ backgroundColor: pink[50], color:grey[500] }}component="th" scope="row">
              {auth.name}
              </TableCell>
              <TableCell style={{ backgroundColor: red[50], color:grey[500] }}align="right"> 
              Delete |
              <Link style={{color : grey[500]}} to ={"/update/"+auth._id}>Edit</Link>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </Zoom>
    </div>
  )
}

export default AuthorDisplay
