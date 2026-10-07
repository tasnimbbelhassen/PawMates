<template>
  <nav class="nav" :class="{ scrolled: isScrolled }">
    <div class="nav-inner">
      <router-link class="nav-logo" to="/">
        <svg viewBox="0 0 28 28" fill="none" width="20" height="20">
          <ellipse cx="7" cy="8" rx="3" ry="4" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="14" cy="5.5" rx="3" ry="3.5" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="21" cy="8" rx="3" ry="4" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="3.5" cy="14.5" rx="2.2" ry="3" fill="#c8a84b" opacity="0.6" />
          <path
            d="M14 12c-5 0-9 3.5-9 7.5 0 3 2 5.5 5 5.5 1.5 0 2.8-.6 4-1.5 1.2.9 2.5 1.5 4 1.5 3 0 5-2.5 5-5.5C23 15.5 19 12 14 12z"
            fill="#c8a84b"
          />
        </svg>
        <span class="nav-logo-text">Paw<span>Mates</span></span>
      </router-link>

      <ul class="nav-links">
        <li><router-link to="/">Accueil</router-link></li>
        <li><router-link to="/posts">Animaux</router-link></li>
        <li v-if="authStore.isAuthenticated">
          <router-link to="/adoption-requests">Mes demandes</router-link>
        </li>
        <li v-if="authStore.isAdmin"><router-link to="/admin">Admin</router-link></li>
      </ul>

      <div class="nav-actions">
        <!-- Guest -->
        <template v-if="!authStore.isAuthenticated">
          <router-link to="/login" class="btn-ghost">Connexion</router-link>
          <div class="btn-divider"></div>
          <router-link to="/register" class="btn-solid">Inscription →</router-link>
        </template>

        <!-- Logged in -->
        <template v-else>
          <router-link to="/posts/create" class="btn-ghost">+ Publier</router-link>
          <div class="btn-divider"></div>
          <div class="user-menu" @click="menuOpen = !menuOpen">
            <span class="user-avatar">{{ authStore.userName.charAt(0).toUpperCase() }}</span>
            <span class="user-name">{{ authStore.userName }}</span>
            <svg
              width="12"
              height="12"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
            >
              <polyline points="6 9 12 15 18 9" />
            </svg>

            <div class="dropdown" v-if="menuOpen">
              <router-link to="/profile" class="dropdown-item" @click="menuOpen = false"
                >Mon profil</router-link
              >
              <div class="dropdown-divider"></div>
              <button class="dropdown-item logout" @click="handleLogout">Se déconnecter</button>
            </div>
          </div>
        </template>
      </div>
    </div>
  </nav>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/authStore'

const router = useRouter()
const authStore = useAuthStore()
const isScrolled = ref(false)
const menuOpen = ref(false)

const onScroll = () => {
  isScrolled.value = window.scrollY > 10
}
onMounted(() => window.addEventListener('scroll', onScroll))
onUnmounted(() => window.removeEventListener('scroll', onScroll))

const handleLogout = () => {
  authStore.logout()
  menuOpen.value = false
  router.push('/')
}
</script>

<style scoped>
.nav {
  position: relative;
  top: 0;
  z-index: 100;
  width: 100%;
  background: transparent;
  border-bottom: 1px solid transparent;
  transition:
    background 0.35s,
    border-color 0.35s,
    backdrop-filter 0.35s;
}
.nav.scrolled {
  background: rgba(255, 255, 255, 0.88);
  backdrop-filter: blur(16px);
  -webkit-backdrop-filter: blur(16px);
  border-bottom-color: #ede9e0;
}
.nav-inner {
  display: flex;
  align-items: center;
  justify-content: space-between;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 2.5rem;
  height: 68px;
  position: relative;
}
.nav-logo {
  display: flex;
  align-items: center;
  gap: 10px;
  text-decoration: none;
  flex-shrink: 0;
}
.nav-logo-text {
  font-family: 'Playfair Display', serif;
  font-size: 1.25rem;
  font-weight: 700;
  color: #1a1a2e;
  letter-spacing: 0.02em;
}
.nav-logo-text span {
  color: #c8a84b;
}
.nav-links {
  display: flex;
  align-items: center;
  list-style: none;
  gap: 0.5rem;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  margin: 0;
  padding: 0;
}
.nav-links li a {
  display: block;
  font-size: 0.78rem;
  font-weight: 400;
  color: #888;
  text-decoration: none;
  padding: 0.45rem 1.1rem;
  letter-spacing: 0.04em;
  position: relative;
  transition: color 0.2s;
}
.nav-links li a::after {
  content: '';
  position: absolute;
  bottom: -1px;
  left: 1.1rem;
  right: 1.1rem;
  height: 1px;
  background: #c8a84b;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.25s ease;
}
.nav-links li a:hover,
.nav-links li a.router-link-active {
  color: #1a1a2e;
}
.nav-links li a:hover::after,
.nav-links li a.router-link-active::after {
  transform: scaleX(1);
}
.nav-actions {
  display: flex;
  align-items: center;
  gap: 0.7rem;
  flex-shrink: 0;
}
.btn-ghost {
  font-size: 0.75rem;
  font-weight: 400;
  color: #888;
  background: transparent;
  border: none;
  padding: 0.4rem 0.8rem;
  cursor: pointer;
  letter-spacing: 0.04em;
  text-decoration: none;
  transition: color 0.2s;
}
.btn-ghost:hover {
  color: #1a1a2e;
}
.btn-divider {
  width: 1px;
  height: 14px;
  background: #e5e0d5;
  flex-shrink: 0;
}
.btn-solid {
  font-size: 0.75rem;
  font-weight: 500;
  color: #fff;
  background: #1a1a2e;
  border: none;
  padding: 0.5rem 1.3rem;
  border-radius: 5px;
  cursor: pointer;
  letter-spacing: 0.04em;
  text-decoration: none;
  transition: background 0.2s;
}
.btn-solid:hover {
  background: #c8a84b;
}

/* User menu */
.user-menu {
  display: flex;
  align-items: center;
  gap: 6px;
  cursor: pointer;
  position: relative;
  padding: 0.3rem 0.6rem;
  border-radius: 6px;
  transition: background 0.2s;
}
.user-menu:hover {
  background: #f5f0e8;
}
.user-avatar {
  width: 28px;
  height: 28px;
  background: #c8a84b;
  color: #fff;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 0.75rem;
  font-weight: 600;
}
.user-name {
  font-size: 0.78rem;
  font-weight: 500;
  color: #1a1a2e;
}
.dropdown {
  position: absolute;
  top: calc(100% + 8px);
  right: 0;
  background: #fff;
  border: 1px solid #ede9e0;
  border-radius: 8px;
  min-width: 180px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  z-index: 200;
}
.dropdown-item {
  display: block;
  width: 100%;
  padding: 0.65rem 1rem;
  font-size: 0.8rem;
  color: #1a1a2e;
  text-decoration: none;
  background: none;
  border: none;
  text-align: left;
  cursor: pointer;
  transition: background 0.15s;
}
.dropdown-item:hover {
  background: #fdf5e8;
}
.dropdown-item.logout {
  color: #e05252;
}
.dropdown-divider {
  height: 1px;
  background: #f0ece4;
  margin: 0.25rem 0;
}
@media (max-width: 768px) {
  .nav-links {
    display: none;
  }
}
</style>
