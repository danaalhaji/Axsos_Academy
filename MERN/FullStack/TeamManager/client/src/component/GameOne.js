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
    const[color1, setColor1] = useState("white")
    const[color2, setColor2] = useState("white")
    const[color0, setColor0] = useState("white")
  // delete a player
  const removeFromDom = proId => {
    setPlayers(player.filter(authors => authors._id != proId));
    console.log(proId);
}
const classes = useStyles();

  return (
    <div>
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
              </TableCell>
              <TableCell style={{ backgroundColor: pink[50], color:grey[500] }}component="th" scope="row">
                {auth.position}
              </TableCell>
              <TableCell style={{ backgroundColor: red[50], color:grey[500] }}align="right">
              <button type="button" value= "2"style={{backgroundColor: auth.g1Status == 2? "green" :""}}>Playing</button>
              <button type="button" value="1" style={{backgroundColor: auth.g1Status == 1? "red" :""}}>Not Playing</button>
              <button type="button" value="0" style={{backgroundColor: auth.g1Status == 0? "yellow" :""}}>Undecided</button>
                
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
