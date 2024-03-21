import api from './api';
import { authHeader } from '../helpers/auth-header';
import { getUserDetails } from '../helpers/user-details';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};

const addProduct = (name, price) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can add products.");
    }

    return api.post('/products/admin/post', { name, price }, { headers: authHeader() });
  }

  const deleteProduct = (id) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can delete products.");
    }

    return api.delete(`/products/${id}`, { headers: authHeader() });
  }

  const updateProduct = (id) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can delete products.");
    }

    return api.put(`/products/${id}`, { headers: authHeader() });
  }


export const productService = { getAllProducts, addProduct, deleteProduct, updateProduct};
