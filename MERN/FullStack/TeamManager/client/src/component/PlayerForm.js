import React, {useState} from 'react'
import axios from 'axios';

import FormControl from '@mui/material/FormControl';
import { grey } from '@mui/material/colors';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Box } from '@mui/system';
// import { navigate } from '@reach/router' 
import Typography from '@mui/material/Typography';

const PlayerForm = (props) => {
    const{initialState , onSubmitProps} = props;
    const[dis, setDis] = useState(true)
    const[name, setName] = useState(initialState.name)
    const[position, setPosition] = useState("")

    /* errors states*/
  const [NameError, setNameError] = useState("");
    const handleSubmit = e=>{
        e.preventDefault();
        console.log("hiiiiiiiiii");
         //make a post request to create a new product
        props.onSubmitProps({name, position})
    };

    //////First Name Validation ///////////
const handleNameValidation = (e) => {
    setName(e.target.value);
    if(e.target.value.length < 3 && e.target.value.length != 0 ) {
        setNameError("Name must be 2 characters or longer!");
        setDis(true)
    } else {
        setNameError("");
        setDis(false);
        console.log(dis)
    }
  }
return (
    <div style={{margin:"0 auto"}}>
        {props.errors.map((err, index) => <p key={index}>{err}</p>)}
        <form onSubmit={handleSubmit}>
            <FormControl>
                <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                    <TextField  id="input-with-sx" label="Title" variant="standard" 
                        value={name}
                        onChange = {handleNameValidation}/>
                </Box>
                {
                    NameError ?
                    <p style={{color:"red"}}>*{ NameError } </p> :
                    ''
                }
                <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                    <TextField  id="input-with-sx" label="Prefered Position" variant="standard" 
                        value={position}
                        onChange = {(e) => setPosition(e.target.value)}/>
                </Box>
                <Typography variant="caption" display="block" gutterBottom style={{color: grey[400]}}>
                        the postion should be one of the following : "Goalkeeper", "Defenders", "Midfielders" , "Forwards"
                    </Typography>
                <Button color="primary" aria-label="Add Product" type="submit" disabled={dis}>Add Player</Button>
            </FormControl>
        </form>
    </div>
    )
}

export default PlayerForm
