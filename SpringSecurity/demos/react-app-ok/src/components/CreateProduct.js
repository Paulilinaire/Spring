import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { productService } from "../services/productService";

const CreateProduct = () => {
  const navigate = useNavigate();
  const { id } = useParams(); // Récupérer l'ID de l'URL
  const [productData, setProductData] = useState({
    name: "",
    price: ""
  });

  useEffect(() => {
    // Si un ID est présent dans l'URL, fetch les données du produit correspondant
    if (id) {
      productService.getProductById(id)
        .then(response => {
          const { name, price } = response.data;
          setProductData({ name, price });
        })
        .catch(error => {
          console.error('Error fetching product data: ', error);
        });
    }
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProductData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const { name, price } = productData;
      if (id) {
        await productService.updateProduct(id, name, price);
        console.log("Product updated successfully");
      } else {
        await productService.addProduct(name, price);
        console.log("Product added successfully");
      }
      navigate('/products');
    } catch (error) {
      console.error("Error adding/updating product: ", error);
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">{id ? "Modifier" : "Créer"} un produit</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">Nom</label>
          <input
            type="text"
            className="form-control"
            id="name"
            name="name"
            value={productData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price" className="form-label">Prix</label>
          <input
            className="form-control"
            type="number"
            min={0} step={0.01}
            id="price"
            name="price"
            value={productData.price}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3 d-flex justify-content-end">
          <button type="submit" className="btn btn-primary">Enregistrer</button>
        </div>
      </form>
    </div>
  );
};

export default CreateProduct;
