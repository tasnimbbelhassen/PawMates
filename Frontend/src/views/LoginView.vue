<template>
  <div class="login-container">
    <div class="left-panel">
      <div class="paw-prints" aria-hidden="true">
        <svg class="paw p1" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
        <svg class="paw p2" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
        <svg class="paw p3" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
        <svg class="paw p4" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
        <svg class="paw p5" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
        <svg class="paw p6" viewBox="0 0 100 100">
          <g fill="currentColor">
            <ellipse cx="50" cy="72" rx="22" ry="18" />
            <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
            <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
            <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
            <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
          </g>
        </svg>
      </div>

      <div class="avatars-scattered" aria-hidden="true">
        <div class="ab ab1"><img src="@/assets/cat3.jpg" alt="chien" /></div>
        <div class="ab ab2"><img src="@/assets/cat.jpg" alt="chat" /></div>
        <div class="ab ab3"><img src="@/assets/chien2.jpg" alt="chien2" /></div>
        <div class="ab ab4"><img src="@/assets/cat2.jpg" alt="chat2" /></div>
        <div class="ab ab5"><img src="@/assets/chien.jpg" alt="chien3" /></div>
        <div class="ab ab6"><img src="@/assets/chien3.jpg" alt="chat3" /></div>
      </div>

      <div class="left-content">
        <p class="left-eyebrow">Réseau social d'adoption</p>
        <h2 class="left-heading">Chaque animal mérite<br /><em>un foyer.</em></h2>
        <p class="left-sub">
          Rejoignez des milliers d'amoureux des animaux et trouvez votre compagnon idéal.
        </p>
      </div>
    </div>

    <div class="right-panel">
      <div class="login-logo">
        <svg width="24" height="24" viewBox="0 0 28 28" fill="none">
          <ellipse cx="7" cy="8" rx="3" ry="4" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="14" cy="5.5" rx="3" ry="3.5" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="21" cy="8" rx="3" ry="4" fill="#c8a84b" opacity="0.9" />
          <ellipse cx="3.5" cy="14.5" rx="2.2" ry="3" fill="#c8a84b" opacity="0.6" />
          <path
            d="M14 12c-5 0-9 3.5-9 7.5 0 3 2 5.5 5 5.5 1.5 0 2.8-.6 4-1.5 1.2.9 2.5 1.5 4 1.5 3 0 5-2.5 5-5.5C23 15.5 19 12 14 12z"
            fill="#c8a84b"
          />
        </svg>
        <span class="logo-text">Paw<span>Mates</span></span>
      </div>

      <p class="right-eyebrow">Bienvenue</p>
      <h1 class="right-heading">Bon retour !<br /><em>Connectez-vous à votre compte</em></h1>

      <form @submit.prevent="handleLogin" class="login-form">
        <div class="form-group">
          <label for="email">Adresse email</label>
          <input
            id="email"
            v-model="form.email"
            type="email"
            placeholder="exemple@email.com"
            required
            :disabled="loading"
          />
        </div>

        <div class="form-group">
          <div class="label-row">
            <label for="password">Mot de passe</label>
            <a href="#" class="forgot-link">Mot de passe oublié ?</a>
          </div>
          <div class="input-password">
            <input
              id="password"
              v-model="form.password"
              :type="showPassword ? 'text' : 'password'"
              placeholder="••••••••"
              required
              :disabled="loading"
            />
            <button
              type="button"
              class="toggle-password"
              @click="showPassword = !showPassword"
              aria-label="Toggle password"
            >
              <svg
                v-if="showPassword"
                width="16"
                height="16"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="1.5"
              >
                <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z" />
                <circle cx="12" cy="12" r="3" />
              </svg>
              <svg
                v-else
                width="16"
                height="16"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="1.5"
              >
                <path
                  d="M17.94 17.94A10.07 10.07 0 0112 20c-7 0-11-8-11-8a18.45 18.45 0 015.06-5.94M9.9 4.24A9.12 9.12 0 0112 4c7 0 11 8 11 8a18.5 18.5 0 01-2.16 3.19m-6.72-1.07a3 3 0 11-4.24-4.24"
                />
                <line x1="1" y1="1" x2="23" y2="23" />
              </svg>
            </button>
          </div>
        </div>
        <!-- add these two lines before the <button type="submit"> -->
        <div v-if="errorMessage" class="alert alert-error">{{ errorMessage }}</div>
        <div v-if="successMessage" class="alert alert-success">{{ successMessage }}</div>

        <button type="submit" class="btn-signin" :disabled="loading">
          {{ loading ? 'Connexion…' : 'Se connecter →' }}
        </button>
      </form>

      <div class="login-footer">
        <span>Pas encore de compte ?</span>
        <router-link to="/register" class="register-link"> S'inscrire </router-link>
      </div>

      <router-link to="/" class="back-home">← Retour à l'accueil</router-link>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/authStore'

const router = useRouter()
const authStore = useAuthStore()

const form = reactive({
  email: '',
  password: '',
})

const showPassword = ref(false)
const loading = ref(false)
const errorMessage = ref('')
const successMessage = ref('')

const handleLogin = async () => {
  errorMessage.value = ''
  loading.value = true

  if (!form.email || !form.password) {
    errorMessage.value = 'Veuillez remplir tous les champs'
    loading.value = false
    return
  }

  const result = await authStore.login(form)

  if (result.success) {
    successMessage.value = 'Connexion réussie ! Redirection...'
    setTimeout(() => {
      router.push('/')
    }, 1500)
  } else {
    errorMessage.value = result.message
  }

  loading.value = false
}
</script>

<style scoped>
.login-container {
  display: flex;
  min-height: 100vh;
  overflow: hidden;
}

.left-panel {
  flex: 1;
  background: #fdf5e8;
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 4rem 3rem;
  overflow: hidden;
}

/* Paw prints */
.paw-prints {
  position: absolute;
  inset: 0;
  pointer-events: none;
  z-index: 0;
}
.paw {
  position: absolute;
  color: #c8a84b;
}
.p1 {
  width: 80px;
  top: 5%;
  left: 3%;
  opacity: 0.12;
  transform: rotate(-25deg);
}
.p2 {
  width: 55px;
  top: 28%;
  left: 7%;
  opacity: 0.09;
  transform: rotate(18deg);
}
.p3 {
  width: 90px;
  top: 65%;
  left: 1%;
  opacity: 0.1;
  transform: rotate(-42deg);
}
.p4 {
  width: 65px;
  top: 10%;
  right: 5%;
  opacity: 0.11;
  transform: rotate(22deg);
}
.p5 {
  width: 75px;
  top: 50%;
  right: 3%;
  opacity: 0.09;
  transform: rotate(-30deg);
}
.p6 {
  width: 60px;
  top: 80%;
  right: 8%;
  opacity: 0.1;
  transform: rotate(50deg);
}

.avatars-scattered {
  position: absolute;
  inset: 0;
  pointer-events: none;
  z-index: 1;
}
.ab {
  position: absolute;
  border-radius: 50%;
  overflow: hidden;
  box-shadow: 0 6px 20px rgba(200, 168, 75, 0.5);
}
.ab img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.ab1 {
  width: 72px;
  height: 72px;
  top: 8%;
  left: 10%;
}
.ab2 {
  width: 56px;
  height: 56px;
  top: 18%;
  right: 12%;
}
.ab3 {
  width: 80px;
  height: 80px;
  top: 42%;
  left: 5%;
}
.ab4 {
  width: 64px;
  height: 64px;
  top: 38%;
  right: 8%;
}
.ab5 {
  width: 60px;
  height: 60px;
  bottom: 18%;
  left: 15%;
}
.ab6 {
  width: 70px;
  height: 70px;
  bottom: 12%;
  right: 10%;
}

.left-content {
  position: relative;
  z-index: 2;
  text-align: center;
  padding: 0 1rem;
}

.left-eyebrow {
  font-size: 0.78rem;
  font-weight: 600;
  letter-spacing: 0.14em;
  text-transform: uppercase;
  color: #c8a84b;
  margin-bottom: 0.75rem;
}

.left-heading {
  font-family: 'Playfair Display', serif;
  font-size: clamp(2.4rem, 4vw, 3.2rem);
  line-height: 1.15;
  color: #1a1a2e;
  margin-bottom: 1rem;
}
.left-heading em {
  font-style: italic;
  color: #c8a84b;
}

.left-sub {
  font-size: 0.9rem;
  color: #999;
  line-height: 1.7;
  max-width: 280px;
  margin: 0 auto;
}

.right-panel {
  flex: 1.1;
  background: #fff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 4rem 4rem;
  max-width: 520px;
}

.login-logo {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 2.5rem;
}
.logo-text {
  font-family: 'Playfair Display', serif;
  font-size: 1.2rem;
  font-weight: 700;
  color: #1a1a2e;
  letter-spacing: 0.02em;
}
.logo-text span {
  color: #c8a84b;
}

.right-eyebrow {
  font-size: 0.7rem;
  font-weight: 600;
  letter-spacing: 0.14em;
  text-transform: uppercase;
  color: #c8a84b;
  margin-bottom: 0.5rem;
}

.right-heading {
  font-family: 'Playfair Display', serif;
  font-size: 1.9rem;
  line-height: 1.2;
  color: #1a1a2e;
  margin-bottom: 10%;
}
.right-heading em {
  font-style: italic;
  color: #1a1a2e;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 6px;
}

.form-group label {
  font-size: 0.75rem;
  font-weight: 500;
  color: #1a1a2e;
  letter-spacing: 0.03em;
}

.label-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.forgot-link {
  font-size: 0.72rem;
  font-weight: 500;
  color: #c8a84b;
  text-decoration: none;
  transition: opacity 0.2s;
}
.forgot-link:hover {
  opacity: 0.7;
}

.form-group input {
  width: 100%;
  padding: 0.7rem 1rem;
  border: 1px solid #e5e0d5;
  border-radius: 8px;
  font-family: 'Inter', sans-serif;
  font-size: 0.875rem;
  color: #1a1a2e;
  background: #fff;
  outline: none;
  transition: border-color 0.2s;
  box-sizing: border-box;
}
.form-group input::placeholder {
  color: #ccc;
}
.form-group input:focus {
  border-color: #c8a84b;
}
.form-group input:disabled {
  opacity: 0.5;
}

.input-password {
  position: relative;
}
.input-password input {
  padding-right: 2.8rem;
}

.toggle-password {
  position: absolute;
  right: 0.8rem;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  color: #bbb;
  display: flex;
  align-items: center;
  padding: 0;
  transition: color 0.2s;
}
.toggle-password:hover {
  color: #1a1a2e;
}

.btn-signin {
  width: 100%;
  padding: 0.85rem;
  background: #c8a84b;
  color: #fff;
  border: none;
  border-radius: 8px;
  font-family: 'Inter', sans-serif;
  font-size: 0.9rem;
  font-weight: 500;
  cursor: pointer;
  transition:
    background 0.2s,
    transform 0.15s;
  margin-top: 0.25rem;
}
.btn-signin:hover:not(:disabled) {
  background: #b8942f;
  transform: translateY(-2px);
}
.btn-signin:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.divider {
  display: flex;
  align-items: center;
  gap: 12px;
  margin: 1.5rem 0;
}
.divider-line {
  flex: 1;
  height: 1px;
  background: #f0ece4;
}
.divider-text {
  font-size: 0.75rem;
  color: #bbb;
  white-space: nowrap;
}

.social-btns {
  display: flex;
  gap: 10px;
}
.btn-social {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  padding: 0.7rem 1rem;
  border: 1px solid #e5e0d5;
  border-radius: 8px;
  background: #fff;
  font-family: 'Inter', sans-serif;
  font-size: 0.85rem;
  font-weight: 500;
  color: #1a1a2e;
  cursor: pointer;
  transition:
    border-color 0.2s,
    background 0.2s;
}
.btn-social:hover {
  border-color: #c8a84b;
  background: #fffbef;
}

.login-footer {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.4rem;
  margin-top: 1.75rem;
  padding-top: 1.5rem;
  border-top: 1px solid #f0ece4;
  font-size: 0.8rem;
  color: #aaa;
}

.register-link {
  font-size: 0.8rem;
  font-weight: 500;
  color: #1a1a2e;
  text-decoration: none;
  position: relative;
  transition: color 0.2s;
}
.register-link::after {
  content: '';
  position: absolute;
  bottom: -1px;
  left: 0;
  right: 0;
  height: 1px;
  background: #c8a84b;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.25s ease;
}
.register-link:hover {
  color: #c8a84b;
}
.register-link:hover::after {
  transform: scaleX(1);
}

.back-home {
  display: block;
  text-align: center;
  margin-top: 1rem;
  font-size: 0.78rem;
  color: #bbb;
  text-decoration: none;
  transition: color 0.2s;
}
.back-home:hover {
  color: #c8a84b;
}
.alert {
  padding: 0.65rem 0.9rem;
  border-radius: 6px;
  font-size: 0.82rem;
  margin-top: 0.25rem;
}
.alert-error {
  background: #fff0f0;
  color: #e05252;
  border: 1px solid #fcd4d4;
}
.alert-success {
  background: #f0faf4;
  color: #3a9e68;
  border: 1px solid #c3e6d4;
}

@media (max-width: 768px) {
  .login-container {
    flex-direction: column;
  }
  .left-panel {
    padding: 3rem 2rem 2rem;
  }
  .pet-image-wrap {
    width: 160px;
    height: 160px;
  }
  .right-panel {
    padding: 2.5rem 1.5rem;
    max-width: 100%;
  }
}
</style>
