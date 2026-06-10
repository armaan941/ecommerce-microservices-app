import ProductCard from "./ProductCard";

function Products({ products }) {
  return (
    <div className="d-flex flex-wrap justify-content-center gap-4 p-3">
      {products.map((product) => (
        <ProductCard key={product.productId} product={product} />
      ))}
    </div>
  );
}

export default Products;
