import React, { useEffect, useState } from 'react'
import axios from 'axios';

import FormControl from '@mui/material/FormControl';
import InventorySharpIcon from '@mui/icons-material/InventorySharp';
import TextField from '@mui/material/TextField';
import DescriptionIcon from '@mui/icons-material/Description';
import AttachMoneyTwoToneIcon from '@mui/icons-material/AttachMoneyTwoTone';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import Button from '@mui/material/Button';
import { Box } from '@mui/system';
import { Link } from '@reach/router';

const Update = (props) => {
    const[title, setTitle] = useState("")
    const[price, setPrice] = useState("")
    const[description, setDesc] = useState("")

    
    useEffect(() => {
        console.log(props.id)
        axios.get('http://localhost:8000/api/products/' + props.id)
            .then(res => {
                console.log(res.data)
                setTitle(res.data.product.title);
                setPrice(res.data.product.price);
                setDesc(res.data.product.description);
            })
    }, []);

    const updateProduct = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/products/' + props.id, {
            title,
            price,
            description
        })
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }

  return (
    <div style={{margin:"0 auto"}}>
    <form onSubmit={updateProduct}>
    <FormControl >
    <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
    <InventorySharpIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
    <TextField  id="input-with-sx" label="Title"
    variant="standard" value={title}
    onChange = {(e) => setTitle(e.target.value)}/>
    </Box>

    <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
    <AttachMoneyTwoToneIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
    <TextField id="input-with-sx" label="Price" 
    variant="standard"
    value={price}
    onChange = {(e) => setPrice(e.target.value)}/>
    {console.log(price)}
    </Box>

    <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
    <DescriptionIcon sx={{ color: 'action.active', mr: 1, my: 0.5 }} />
    <TextField id="input-with-sx" label="Description" 
    variant="standard" 
    rows={4}
    value={description}
    onChange = {(e) => setDesc(e.target.value)}/>
    </Box>
    <Link to={"/" + props.id}>
    <Button color="primary" aria-label={`Update Product ${title}`} type="submit" >
    <AddShoppingCartIcon />
    {`Update  ${title}`}
    </Button>
    </Link>
    </FormControl>
    </form>
    </div>
  )
}

export default Update
