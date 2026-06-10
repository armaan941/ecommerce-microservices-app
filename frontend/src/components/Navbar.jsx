import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useEffect, useState } from "react";
import axios from "axios";
import "./Navbar.css";

function NavbarComponent() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/category")
      .then((res) => setCategories(res.data));
  }, []);

  const parentCategories = categories.filter(
    (c) => c.parentCategoryName === null,
  );

  const getChildren = (parentName) =>
    categories.filter((c) => c.parentCategoryName === parentName);

  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container fluid>
        <Navbar.Brand href="#">NovaCart</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Nav.Link href="#action1">Home</Nav.Link>

            <NavDropdown
              title="Categories"
              id="navbarScrollingDropdown"
              menuVariant="light"
              className="category-dropdown"
            >
              {parentCategories.map((parent) => (
                <div key={parent.categoryId}>
                  <NavDropdown.Header>{parent.categoryName}</NavDropdown.Header>

                  {getChildren(parent.categoryName).map((child) => (
                    <NavDropdown.Item key={child.categoryId}>
                      {child.categoryName}
                    </NavDropdown.Item>
                  ))}

                  <NavDropdown.Divider />
                </div>
              ))}
            </NavDropdown>

            <Nav.Link href="#" disabled>
              Link
            </Nav.Link>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavbarComponent;
