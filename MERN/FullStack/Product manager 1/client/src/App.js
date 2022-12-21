import logo from './logo.svg';
import './App.css';
import AllProducts from './views/AllProducts';
import Details from './views/Details';
import { Router } from '@reach/router'
function App() {
  return (
    <div className="App">
      <Router>
        <AllProducts path="/"></AllProducts>
        <Details path="/:id"/>
      </Router>
    </div>
  );
}

export default App;
