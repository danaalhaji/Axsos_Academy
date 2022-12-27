import logo from './logo.svg';
import './App.css';
import Create from './veiws/Create';
import Main from './veiws/Main';
import DisplayG1 from './veiws/DisplayG1';
import { Router } from '@reach/router';
import Header from './veiws/Header';


function App() {
  return (
    <div className="App">
      
      <Router>
      <Header path="/"></Header>
        <Main path="/player/list"></Main>
        <Create path="/player/create"></Create>
        <DisplayG1 path ="/player/game/:num"></DisplayG1>
      </Router>
    </div>
  );
}

export default App;
