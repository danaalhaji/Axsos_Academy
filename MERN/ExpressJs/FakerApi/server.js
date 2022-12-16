// The import line will look different than what is in Faker's documentation
// because we are working with an express application
const { faker } = require('@faker-js/faker');
// we can create a function to return a random / fake "Product"

const express = require("express");
const app = express();
const port = 8000;

// const createProduct = () => {
//     const newFake = {
//         name: faker.commerce.productName(),
//         price: "$" + faker.commerce.price(),
//         department: faker.commerce.department()
//     };
//     return newFake;
// };
    
// const newFakeProduct = createProduct();
// console.log(newFakeProduct);
/*
 * The output of the above console log will look like this
 * {
 *   name: 'Anime Figure',
 *   price: '$568.00
 *   department: 'Tools' 
 * }
 */

// new fake person
const createPerson = () => {
  const newFake = {
    password: faker.internet.password(),
    lastName: faker.name.lastName(),
    firstName: faker.name.firstName(),
    phoneumber :faker.phone.number(),
    email : faker.internet.email(),
    id : faker.datatype.number({ max: 1000000 })

  };
  return newFake;
};


// new fake company
const createCompay = () =>{
  const newFake ={
    id : faker.datatype.number({ max: 1000000 }),
    name : faker.company.bsNoun(),
    adress :{
      street : faker.address.street() ,
      city :faker.address.cityName(),
      zipCode :faker.address.zipCode() ,
      state: faker.address.state(),
      country:faker.address.county(),
    }};
    return newFake;
};



const newFakePerson = createPerson();
const newFakeCompany = createCompay();
const newObjectUC = {
  newFakePerson,newFakeCompany
}

// req is short for request
// res is short for response
app.get("/api", (req, res) => {
  res.send("Our express api server is now sending this over to the browser");
});

app.get("/api/users/new", (req, res) => {
  res.json(newFakePerson);
});

app.get("/api/company/new", (req, res) => {
  res.json(newFakeCompany);
});

app.get("/api/company/users", (req, res) => {
  res.json(newObjectUC);
});
const server = app.listen(port, () =>
  console.log(`Server is locked and loaded on port ${server.address().port}!`)
);
