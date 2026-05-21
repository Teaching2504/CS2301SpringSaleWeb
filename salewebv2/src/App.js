import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Home from "./screens/Home/Home";
import Footer from "./components/Footer";
import 'bootstrap/dist/css/bootstrap.min.css';
import Register from "./screens/User/Register";
import Login from "./screens/User/Login";
import { MyCartContext, MyUserContext } from "./configs/Contexts";
import { useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookies from 'react-cookies';
import MyCartReducer from "./reducers/MyCartReducer";
import Cart from "./screens/Cart/Cart";
import ProductDetails from "./screens/Home/ProductDetails";
//import ProductDetails from "./screens/Home/ProductDetails";

const App = () => {
  
  const [user, dispatch] = useReducer(MyUserReducer, null);
  const[cartCounter, dispatchCartCounter]= useReducer(MyCartReducer, {'totalQuantity': 0, "totalAmount": 0});

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <MyCartContext.Provider value={[cartCounter, dispatchCartCounter]}>
        <BrowserRouter>
          <Header />

          <Container>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/register" element={<Register />} />
              <Route path="/login" element={<Login />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/products/:productId" element={<ProductDetails/>}/>
            </Routes>
          </Container>

          <Footer />
        </BrowserRouter>
      </MyCartContext.Provider>
    </MyUserContext.Provider>
  );
}

export default App;