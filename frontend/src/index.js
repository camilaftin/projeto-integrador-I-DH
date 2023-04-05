import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import Home from "./pages/home/index";
import LoginScreen from "./pages/login/index";
import CreateAccountScreen from "./pages/createAccount/";
import reportWebVitals from "./reportWebVitals";
import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import 'bootstrap-daterangepicker/daterangepicker.css';
import ProductScreen from "./pages/product";
import RentScreen from "./pages/rent";
import ProductListScreen from "./pages/productList";
import Faq from './pages/faq/index'
import Contact from './pages/contact/index'



const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route index element={<Home />} />
        <Route path="/entrar" element={<LoginScreen />} />
        <Route path="/rent" element={<RentScreen />} />
        <Route path="/produtos" element={<ProductListScreen />} />
        <Route path="/criar-conta" element={<CreateAccountScreen />} />
        <Route path="/produto" element={<ProductScreen />} />
        <Route path="/faq" element={<Faq />} />
        <Route path="/contato" element={<Contact />} />

      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
