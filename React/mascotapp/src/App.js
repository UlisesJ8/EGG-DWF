import { Route, Routes} from "react-router-dom";
import './App.css';
import { Footer } from './components/public/Footer';
import Main from './components/public/Main';
import  NavBar  from './components/public/NavBar';
import UserForm from "./components/public/UserForm";
import Details from "./components/public/Detail";

function App() {
  return (
    <div>
      

    <NavBar> </NavBar>

    <Routes>
    <Route exact path={"/"} element={<Main/>}></Route>
    <Route exact path={"/detail/:id"} element={<Details/>}></Route>
    <Route exact path={"/user-form"} element={<UserForm/>}></Route>
    </Routes>

    <Footer></Footer>

    
    </div>
  );
}

export default App;
