import logo from './logo.svg';
import './App.css';
import AllProducts from './views/AllProducts';
import Details from './views/Details';
import { Router } from '@reach/router'
import Update from './views/Update';
function App() {
  return (
    <div className="App">
      <Router>
        <AllProducts path="/"></AllProducts>
        <Details path="/:id"/>
        <Update path="/update/:id"/>
      </Router>
    </div>
  );
}

export default App;
