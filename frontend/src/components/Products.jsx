import { useEffect, useState } from "react";
import axios from "axios";
import ProductCard from "./ProductCard";

function Products() {
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
    <div className="d-flex flex-wrap justify-content-center gap-4 p-3">
      {products.map((product) => (
        <ProductCard key={product.productId} product={product} />
      ))}
    </div>
  );
}

export default Products;
