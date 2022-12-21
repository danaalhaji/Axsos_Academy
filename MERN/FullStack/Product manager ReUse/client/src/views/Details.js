import React, { useEffect, useState } from 'react'
import axios from 'axios';


import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';

// import { useParams } from "react-router-dom";


const bull = (
    <Box
      component="span"
      sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
    >
      •
    </Box>
  );
  
const Detail = (props) => {
    const [products, setProducts] = useState(null)
    const [loaded , setLoaded] = useState(false)
    // const { id } = useParams();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + props.id)
            .then(res => {setProducts(res.data); setLoaded(true);})
            .catch(err => console.error(err));
    }, []);
    return (
        <div sx={{ minWidth: 275 }}>
        <Box
      sx={{
        display: 'flex',
        flexWrap: 'wrap',
        '& > :not(style)': {
          m: 1,
          width: 128,
          height: 128,
        },
      }}
    >
        <Paper elevation={6} sx={{ minWidth: 275 }}>
        <Card sx={{ maxWidth: 275 }}>
      <CardContent>
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          product of the Day :{loaded &&  products.product.title}
        </Typography>
        <Typography variant="h5" component="div">
        {bull}{loaded && products.product.title}{bull}
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
        {loaded && products.product.description}
        </Typography>
        <Typography variant="body2">
        Des{bull}C{bull}ri{bull}ption<br></br>
        {loaded && products.product.description}
          <br />
          {loaded && products.product.price}$
        </Typography>
      </CardContent>
    </Card>
    </Paper>
    </Box>
        </div>
    )
}
    
export default Detail;