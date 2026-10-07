import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
      meta: { guestOnly: true },
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/RegisterView.vue'),
      meta: { guestOnly: true },
    },
    {
      path: '/posts',
      name: 'posts',
      component: () => import('../views/PostsView.vue'),
    },
    // ✅ /posts/create AVANT /posts/:id
    {
      path: '/posts/create',
      name: 'post-create',
      component: () => import('../views/CreatePostView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/posts/:id/edit',
      name: 'post-edit',
      component: () => import('../views/EditPostView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/posts/:id',
      name: 'post-detail',
      component: () => import('../views/PostDetailView.vue'),
    },
    {
      path: '/my-posts',
      name: 'my-posts',
      component: () => import('../views/MyPostsView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/adoption-requests',
      name: 'adoption-requests',
      component: () => import('../views/AdoptionRequestsView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/donations',
      name: 'donations',
      component: () => import('../views/DonationsView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/profile',
      name: 'profile',
      component: () => import('../views/ProfileView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../views/AdminView.vue'),
      meta: { requiresAuth: true, requiresAdmin: true },
    },
  ],
})

// ✅ FIX: utiliser return au lieu de next(value) — next() sans argument reste valide
router.beforeEach((to, from) => {
  const token = localStorage.getItem('token')
  const user = JSON.parse(localStorage.getItem('user') || 'null')

  if (to.meta.requiresAuth && !token) {
    return '/login'
  }
  if (to.meta.requiresAdmin && user?.role !== 'admin') {
    return '/'
  }
  if (to.meta.guestOnly && token) {
    return '/'
  }
  // Pas de return = navigation autorisée (équivalent de next())
})

export default router