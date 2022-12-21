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
import ProductForm from '../components/ProductForm';

const Update = (props) => {

    const[product, setProduct] = useState(null);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(() => {
        console.log(props.id)
        axios.get('http://localhost:8000/api/products/' + props.id)
            .then(res => {
                console.log(res.data)
                setProduct(res.data.product);
                setLoaded(true);
            })
    }, []);

    const updateProduct = product => {
        axios.put('http://localhost:8000/api/products/' + props.id, product)
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }

  return (
    <div style={{margin:"0 auto"}}>
        {
            loaded && ( <ProductForm onSubmitProp={updateProduct} initialState={product} />)
        }
    </div>
  )
}

export default Update
