import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import UpdateProductModal from './UpdateProductModal';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, []);


  const loadProducts = () => {
    productService.getAllProducts()
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  };

  const [selectedProduct, setSelectedProduct] = useState(null);

  const updateProduct = (productData) => {
    console.log("product " + productData.name)
    productService.updateProduct(productData)
      .then(() => {
        loadProducts();
        setSelectedProduct(null);
      })
      .catch(error => {
        setError('Erreur lors de la mise à jour du produit.');
      });
  };

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
      <table className="table text-center">
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
                <button onClick={() => handleDelete(product.id)} className='btn btn-danger mr-2'>Supprimer</button>
                <button className='btn btn-warning' onClick={() => setSelectedProduct(product)}>Update</button>
              </td>
            </tr>
          ))}
          {selectedProduct && (
                  <UpdateProductModal
                    product={selectedProduct}
                    onSave={updateProduct}
                    onCancel={() => setSelectedProduct(null)}
                  />
                )}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
