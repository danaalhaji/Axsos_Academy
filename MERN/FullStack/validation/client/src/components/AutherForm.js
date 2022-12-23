import React, {useState} from 'react'
import axios from 'axios';

import FormControl from '@mui/material/FormControl';
import InventorySharpIcon from '@mui/icons-material/InventorySharp';
import TextField from '@mui/material/TextField';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import Button from '@mui/material/Button';
import HomeIcon from '@mui/icons-material/Home';
import { Box } from '@mui/system';

import { navigate } from '@reach/router' 
import { Link } from '@reach/router';

export default (props) =>{
    const { initialName, onSubmitProp } = props;
    const [name, setName] = useState(initialName);
    const handleSubmit = e=>{
        e.preventDefault();
        console.log("hiiiiiiiiii");
             //make a post request to create a new product
            props.onSubmitProp({name})
            
            
    };

    return(
        <div style={{margin:"0 auto", marginTop:"10%"}}>
        <Link style={{margin:"0 auto", marginBottom:"10%"}} to={"/"}><HomeIcon></HomeIcon>
            Home</Link>
        <form onSubmit={handleSubmit}>
        {props.lerror && props.errors.map((err, index) => <p key={index}>{err}</p>)}
        <FormControl >
        <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
        <InventorySharpIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
        <TextField  id="input-with-sx" label="Name" variant="standard" 
        value={name}
        onChange = {(e) => setName(e.target.value)}/>
        </Box>
        <Button color="primary" aria-label="Add Product" type="submit">
        Submit
        </Button>

        <Button color="primary" aria-label="Add Product" type="submit" onClick={()=>navigate('/')}>
        Cancel
        </Button>
        </FormControl>
        </form>
        </div>
    )
}
