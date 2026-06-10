import React from "react";
import NavbarComponent from "../components/Navbar";
import Products from "../components/Products";
import { useState, useEffect } from "react";
import axios from "axios";

const Home = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/product/get-products")
      .then((res) => {
        setProducts(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <>
      <NavbarComponent setProducts={setProducts} />
      <Products products={products} />
    </>
  );
};

export default Home;
