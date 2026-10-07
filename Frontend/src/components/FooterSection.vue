<template>
  <footer class="footer">
    <div class="paw-prints" aria-hidden="true">
      <svg class="paw fp1" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp2" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp3" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp4" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp5" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp6" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp7" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw fp8" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
    </div>

    <div class="yellow-blob"></div>

    <div class="footer-grid">
      <div class="footer-brand">
        <div class="brand-logo">
          <span class="logo-icon">🐾</span>
          <span class="logo-name">PawMates</span>
        </div>
        <p class="brand-tagline">
          Le réseau social d'adoption qui place le bien-être animal au cœur de chaque rencontre.
        </p>

        <div class="cta-buttons" v-if="!authStore.isAuthenticated">
        <button class="btn-connexion">Connexion</button>
        <button class="btn-inscription">Inscription</button>
      </div>

        <div class="social-links">
          <a href="#" aria-label="Instagram" class="social-btn">
            <svg
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              width="17"
              height="17"
            >
              <rect x="2" y="2" width="20" height="20" rx="5" />
              <path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z" />
              <line x1="17.5" y1="6.5" x2="17.51" y2="6.5" />
            </svg>
          </a>
          <a href="#" aria-label="Facebook" class="social-btn">
            <svg viewBox="0 0 24 24" fill="currentColor" width="17" height="17">
              <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z" />
            </svg>
          </a>
          <a href="#" aria-label="TikTok" class="social-btn">
            <svg viewBox="0 0 24 24" fill="currentColor" width="17" height="17">
              <path
                d="M19.59 6.69a4.83 4.83 0 0 1-3.77-4.25V2h-3.45v13.67a2.89 2.89 0 0 1-2.88 2.5 2.89 2.89 0 0 1-2.89-2.89 2.89 2.89 0 0 1 2.89-2.89c.28 0 .54.04.79.1V9.01a6.33 6.33 0 0 0-.79-.05 6.34 6.34 0 0 0-6.34 6.34 6.34 6.34 0 0 0 6.34 6.34 6.34 6.34 0 0 0 6.33-6.34V8.69a8.18 8.18 0 0 0 4.78 1.52V6.76a4.85 4.85 0 0 1-1.01-.07z"
              />
            </svg>
          </a>
        </div>
      </div>

      <div class="footer-col">
        <h4 class="col-title">Navigation</h4>
        <ul>
          <li>
            <router-link to="/">Accueil</router-link>
            </li>
          <li><router-link to="/posts">Adopter un animal</router-link></li> 
          <li><a href="#">Comment ça marche</a></li>
          <li><a href="#">À propos de nous</a></li>
        </ul>
      </div>

      <div class="footer-col footer-newsletter">
        <h4 class="col-title">Restez informé</h4>
        <p class="newsletter-desc">
          Recevez les dernières actualités sur les animaux disponibles près de chez vous.
        </p>
        <div class="newsletter-form">
          <input type="email" placeholder="Votre adresse e-mail" class="newsletter-input" />
          <button class="newsletter-btn">→</button>
        </div>
      </div>
    </div>

    <div class="footer-divider"></div>

    <div class="footer-bottom">
      <p class="copyright">© 2025 PawMates. Tous droits réservés.</p>
    </div>
  </footer>
</template>

<script setup>
import { useAuthStore } from '@/stores/authStore'

const authStore = useAuthStore()

</script>

<style scoped>
.footer {
  position: relative;
  background: #fff;
  overflow: hidden;
  padding: 5rem 5vw 2.5rem;
  border-top: 1px solid #f0f0f0;
}

/* ── YELLOW BLOB — unchanged ── */
.yellow-blob {
  position: absolute;
  left: -220px;
  bottom: -600px;
  width: 1250px;
  height: 900px;
  background: #f5d96b;
  border-radius: 10% 80% 40% 40% / 10% 40% 50% 40%;
  z-index: 0;
  pointer-events: none;
}

.paw-prints {
  position: absolute;
  inset: 0;
  pointer-events: none;
  z-index: 1;
}

.paw {
  position: absolute;
}

.fp1 {
  width: 88px;
  bottom: 10%;
  left: 2%;
  color: #fff;
  opacity: 0.25;
  transform: rotate(20deg);
}
.fp2 {
  width: 70px;
  bottom: 35%;
  left: 5%;
  color: #fff;
  opacity: 0.2;
  transform: rotate(-35deg);
}
.fp3 {
  width: 78px;
  bottom: 55%;
  left: 1%;
  color: #fff;
  opacity: 0.18;
  transform: rotate(50deg);
}
.fp4 {
  width: 62px;
  bottom: 5%;
  left: 20%;
  color: #fff;
  opacity: 0.16;
  transform: rotate(-15deg);
}

.fp5 {
  width: 80px;
  top: 6%;
  right: 3%;
  color: #c8a84b;
  opacity: 0.1;
  transform: rotate(-22deg);
}
.fp6 {
  width: 66px;
  top: 40%;
  right: 7%;
  color: #c8a84b;
  opacity: 0.08;
  transform: rotate(30deg);
}
.fp7 {
  width: 74px;
  bottom: 20%;
  right: 2%;
  color: #c8a84b;
  opacity: 0.09;
  transform: rotate(-48deg);
}
.fp8 {
  width: 58px;
  top: 18%;
  right: 28%;
  color: #c8a84b;
  opacity: 0.07;
  transform: rotate(14deg);
}

.footer-grid {
  position: relative;
  z-index: 2;
  display: grid;
  grid-template-columns: 1.5fr 1fr 1.4fr;
  gap: 3rem 5rem;
  max-width: 1100px;
  margin: 0 auto 3.5rem;
}

.brand-logo {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 1rem;
}

.logo-icon {
  font-size: 1.6rem;
}

.logo-name {
  font-family: 'Playfair Display', serif;
  font-size: 1.5rem;
  font-weight: 900;
  color: #1a1a2e;
  letter-spacing: -0.5px;
}

.brand-tagline {
  font-size: 0.88rem;
  color: #888;
  line-height: 1.7;
  max-width: 260px;
  margin-bottom: 1.6rem;
}

.cta-buttons {
  display: flex;
  gap: 10px;
  margin-bottom: 1.6rem;
}

.btn-connexion {
  padding: 0.6rem 1.4rem;
  border-radius: 7px;
  font-size: 0.85rem;
  font-family: 'DM Sans', sans-serif;
  font-weight: 500;
  cursor: pointer;
  border: 1.5px solid #1a1a2e;
  background: transparent;
  color: #1a1a2e;
  transition: all 0.2s;
}
.btn-connexion:hover {
  background: #1a1a2e;
  color: #fff;
}

.btn-inscription {
  padding: 0.6rem 1.4rem;
  border-radius: 7px;
  font-size: 0.85rem;
  font-family: 'DM Sans', sans-serif;
  font-weight: 600;
  cursor: pointer;
  border: none;
  background: #1a1a2e;
  color: #fff;
  transition: all 0.2s;
}
.btn-inscription:hover {
  background: #c8a84b;
}

.social-links {
  display: flex;
  gap: 10px;
}

.social-btn {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 38px;
  height: 38px;
  border-radius: 50%;
  background: #1a1a2e;
  color: #fff;
  text-decoration: none;
  transition:
    background 0.2s,
    transform 0.15s;
}
.social-btn:hover {
  background: #c8a84b;
  transform: translateY(-2px);
}

.col-title {
  font-family: 'Playfair Display', serif;
  font-size: 1rem;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 1.2rem;
  position: relative;
}

.col-title::after {
  content: '';
  display: block;
  width: 24px;
  height: 2px;
  background: #c8a84b;
  margin-top: 6px;
  border-radius: 2px;
}

.footer-col ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-direction: column;
  gap: 0.65rem;
}

.footer-col ul li a {
  text-decoration: none;
  font-size: 0.88rem;
  color: #777;
  transition: color 0.2s;
  display: inline-flex;
  align-items: center;
  gap: 6px;
}
.footer-col ul li a:hover {
  color: #c8a84b;
}

.newsletter-desc {
  font-size: 0.85rem;
  color: #888;
  line-height: 1.65;
  margin-bottom: 1rem;
}

.newsletter-form {
  display: flex;
  border: 1.5px solid #e8e0cc;
  border-radius: 8px;
  overflow: hidden;
  margin-bottom: 0.6rem;
  transition: border-color 0.2s;
}
.newsletter-form:focus-within {
  border-color: #c8a84b;
}

.newsletter-input {
  flex: 1;
  border: none;
  outline: none;
  padding: 0.7rem 0.9rem;
  font-size: 0.85rem;
  font-family: 'DM Sans', sans-serif;
  color: #1a1a2e;
  background: transparent;
}
.newsletter-input::placeholder {
  color: #bbb;
}

.newsletter-btn {
  background: #1a1a2e;
  color: #fff;
  border: none;
  padding: 0 1.1rem;
  font-size: 1.1rem;
  cursor: pointer;
  transition: background 0.2s;
}
.newsletter-btn:hover {
  background: #c8a84b;
}

.footer-divider {
  position: relative;
  z-index: 2;
  max-width: 1100px;
  margin: 0 auto 1.8rem;
  height: 1px;
  background: linear-gradient(90deg, #e8e0cc 0%, #f5d96b44 50%, #e8e0cc 100%);
}

.footer-bottom {
  position: relative;
  z-index: 2;
  max-width: 1100px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
  gap: 0.8rem;
}

.copyright {
  font-size: 0.8rem;
  color: #aaa;
}

@media (max-width: 900px) {
  .footer-grid {
    grid-template-columns: 1fr 1fr;
  }
}

@media (max-width: 560px) {
  .footer-grid {
    grid-template-columns: 1fr;
    gap: 2.5rem;
  }
  .footer-bottom {
    flex-direction: column;
    align-items: flex-start;
  }
  .yellow-blob {
    width: 600px;
    height: 500px;
    left: -150px;
    bottom: -300px;
  }
}
</style>
