import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import CreateProduct from './CreateProduct'; // Import CreateProduct component
import { useParams } from 'react-router-dom'; // Import useParams from react-router-dom

function ProductList() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');
  const { id } = useParams(); // Récupérer l'ID de l'URL
  const [productToEdit, setProductToEdit] = useState(null); 

  useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });

    if (id) {
      // Si un ID est présent dans l'URL, fetch le produit correspondant
      productService.getProductById(id)
        .then(response => {
          setProductToEdit(response.data);
        })
        .catch(error => {
          console.error('Error fetching product data: ', error);
        });
    }
  }, [id]); // Assurez-vous de déclencher cet effet à chaque fois que l'ID change

  const handleDelete = async (id) => {
    try {
      await productService.deleteProduct(id);
      console.log('Product deleted successfully');
      const updatedProducts = products.filter(product => product.id !== id);
      setProducts(updatedProducts);
    } catch (error) {
      console.error('Error deleting product: ', error);
    }
  };

  return (
    <div className="container mt-5">
      <h2>Product List</h2>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id}>
              <th scope="row">{index + 1}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              <td>
                <button onClick={() => handleDelete(product.id)} className='btn btn-outline-danger'>Supprimer</button>
                <button onClick={() => setProductToEdit(product)} className='btn btn-outline-warning'>Editer</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {productToEdit && <CreateProduct product={productToEdit} />}
    </div>
  );
}

export default ProductList;
