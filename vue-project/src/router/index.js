import { createRouter, createWebHistory } from 'vue-router'
const Management = () => import("@/components/management/management.vue");
const NotFound = () => import("@/components/error/404.vue");
const Product = () => import("@/view/product/product.vue");
const Home = () => import("@/view/home/home.vue");
const Login = () => import("@/view/login/login.vue");
const Register = () => import("@/view/register/register.vue");
const Admin = () => import("@/view/admin/admin.vue");
const ProductDetail = () => import("@/view/product-detail/product-detail.vue");

const Authority = {
  USER: 'ROLE_USER',
  ADMIN: 'ROLE_ADMIN',
  GUEST: 'ROLE_GUEST'
}

const router = createRouter({
  history: createWebHistory("micro"),
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        title: "Đăng nhập",
        isLogin: false,
        authorities: [Authority.GUEST]
      },
    },
    {
      path: '/register',
      name: 'Register',
      component: Register,
      meta: {
        title: "Đăng ký",
        isLogin: false,
        authorities: [Authority.GUEST]
      },
    },
    {
      path: '/management',
      name: 'Management',
      component: Management,
      meta: {
      },
      children: [
        {
          path: '/',
          name: 'Home',
          component: Home,
          meta: {
            title: "Trang Chủ",
            isLogin: false,
            authorities: [Authority.GUEST]
          },
        },
        {
          path: '/product/',
          name: 'Product',
          component: Product,
          meta: {
            title: "Sản Phẩm",
            isLogin: false,
            authorities: [Authority.USER]
          },
        },
        {
          path: '/product/product-detail/:id',
          name: 'ProductDetail',
          component: ProductDetail,
          meta: {
            title: "Chi tiết sản phẩm",
            isLogin: false,
            authorities: [Authority.USER]},
        },
        {
          path: '/admin',
          name: 'Admin',
          component: Admin,
          meta: {
            title: "Admin",
            isLogin: false,
            authorities: [Authority.ADMIN]
          }
        },
      ]
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: NotFound,
      meta: {
        error: true,
        title: 'Trang Không Tồn Tại',
        authorities: []
      },
    },
  ]
})

router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem("token") !== null;
  const userRole = localStorage.getItem("current-account") ? JSON.parse(localStorage.getItem("current-account")).authority : null;

  if (to.meta.isLogin) {
    if (isAuthenticated) {
      if (to.meta.authorities && !to.meta.authorities.includes(userRole)) {
        next('/');
      } else {
        next();
      }
    } else {
      next('/login');
    }
  } else {
    next();
  }
})

function checkAuthentication() {
  return localStorage.getItem("token") != null;
}

function getAuthority() {
  if (checkAuthentication()) {
    return JSON.parse(localStorage.getItem('current-account')).authority;
  } else {
    return Authority.GUEST;
  }
}

export default router

