import React, {useState} from 'react'
import axios from 'axios';

import FormControl from '@mui/material/FormControl';
import InventorySharpIcon from '@mui/icons-material/InventorySharp';
import TextField from '@mui/material/TextField';
import DescriptionIcon from '@mui/icons-material/Description';
import AttachMoneyTwoToneIcon from '@mui/icons-material/AttachMoneyTwoTone';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import Button from '@mui/material/Button';
import { Box } from '@mui/system';

export default () =>{
    const [title, setTitle] = useState("");
    const[price, setPrice] = useState(0);
    const[description, setDesc] = useState("");

    const handleSubmit = e=>{
        e.preventDefault();
        console.log("hiiiiiiiiii");
             //make a post request to create a new product
            axios.post('http://localhost:8000/api/products',{
                title,
                price,
                description
            })
                .then(res=> console.log(res))
                .catch(err=>console.log(err.response.data));
    };

    return(
        <div style={{margin:"0 auto"}}>
        <form onSubmit={handleSubmit}>
        <FormControl >
        <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
        <InventorySharpIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
        <TextField  id="input-with-sx" label="Title" variant="standard" 
        onChange = {(e) => setTitle(e.target.value)}/>
        </Box>

        <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
        <AttachMoneyTwoToneIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
        <TextField id="input-with-sx" label="Price" variant="standard"
        onChange = {(e) => setPrice(e.target.value)}/>
        {console.log(price)}
        </Box>

        <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
        <DescriptionIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
        <TextField id="input-with-sx" label="Description" variant="standard" 
        rows={4}
        onChange = {(e) => setDesc(e.target.value)}/>
        </Box>
        <Button color="primary" aria-label="Add Product" type="submit" >
        <AddShoppingCartIcon />
        Add Product
        </Button>
        </FormControl>
        </form>
        </div>
    )
}
