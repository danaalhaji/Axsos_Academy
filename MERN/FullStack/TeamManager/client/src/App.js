import logo from './logo.svg';
import './App.css';
import Create from './veiws/Create';
import Main from './veiws/Main';
import DisplayG1 from './veiws/DisplayG1';
import { Router } from '@reach/router';
import Header from './veiws/Header';
import Home from './veiws/Home';
import DisplayG2 from './veiws/DisplayG2';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <Router>
        <Home path="/"></Home>
        <Main path="/player/list"></Main>
        <Create path="/player/create"></Create>
        <DisplayG1 path ="/player/status"></DisplayG1>
        <DisplayG2 path="/player/game2"></DisplayG2>
      </Router>
    </div>
  );
}

export default App;
