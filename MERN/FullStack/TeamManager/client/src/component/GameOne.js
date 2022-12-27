import React, { useEffect, useState } from 'react';
import axios from 'axios';

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

// set table width
const useStyles = makeStyles({
    table: {
      minWidth: 300,
    },
  });


  
const GameOne = (props) => {
    const[player, setPlayers] = useState(props.Players)

// styles for table
const classes = useStyles();

// update the status for the player
const statuss = (id, v)=>{
    console.log(v)
    props.update(id, v);
    // setPlayers(props.Players);
}

  return (
    <div style={{width:"60%", margin:"0 auto"}}>
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">  
        <TableHead>
          <TableRow>
            <TableCell style={{ backgroundColor: pink[500] , color:grey[50]}}>Name</TableCell>
            <TableCell style={{ backgroundColor: pink[500], color:grey[50] }} align="right">Prefered Position</TableCell>
            <TableCell style={{ backgroundColor: pink[500], color:grey[50] }} align="right">Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {player.map((auth , idx) => (
            <TableRow  key={idx}>
              <TableCell style={{ backgroundColor: pink[50], color:grey[500] }}component="th" scope="row">
                {auth.name}
                {console.log(auth.g1Status)}
              </TableCell>
              <TableCell style={{ backgroundColor: pink[50], color:grey[500] }}component="th" scope="row">
                {auth.position}
              </TableCell>
              <TableCell style={{ backgroundColor: red[50], color:grey[500] }}align="right">
              <button  value= "2" style={{backgroundColor: auth.g1Status == 2? "green" :""}} 
              onClick={e=> statuss(auth._id,2)}>Playing</button>
              <button value="1" style={{backgroundColor: auth.g1Status == 1? "red" :""}}
              onClick={e=> statuss(auth._id,1)}> Not Playing </button>
              <button value="0" style={{backgroundColor: auth.g1Status == 0? "yellow" :""}}
              onClick={e=> statuss(auth._id,0)}>Undecided</button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>
  )
}

export default GameOne
