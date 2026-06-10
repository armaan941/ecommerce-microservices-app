import Card from "react-bootstrap/Card";

function ProductCard({ product }) {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Img
        variant="top"
        src={product.imageUrl || "https://placehold.co/600x400"}
      />

      <Card.Body>
        <Card.Title>{product.productName}</Card.Title>

        <Card.Text>{product.productDescription}</Card.Text>

        <h5>${product.productPrice}</h5>
      </Card.Body>
    </Card>
  );
}

export default ProductCard;
