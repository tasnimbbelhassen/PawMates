<template>
  <div class="page">
    <NavBar />

    <!-- ══════════════════ PAGE BACKGROUND ══════════════════ -->
    <div class="page-bg" v-if="post">
      <!-- Paw prints background -->
<div class="paw-prints" aria-hidden="true">
  <svg class="paw p1" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>

  <svg class="paw p2" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>

  <svg class="paw p3" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>

  <svg class="paw p4" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>

  <svg class="paw p5" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>

  <svg class="paw p6" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
    <g fill="currentColor">
      <ellipse cx="50" cy="72" rx="22" ry="18" />
      <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
      <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
      <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
      <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
    </g>
  </svg>
  <svg class="paw p7" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>

<svg class="paw p8" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>

<svg class="paw p9" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>

<svg class="paw p10" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>

<svg class="paw p11" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>

<svg class="paw p12" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
  <g fill="currentColor">
    <ellipse cx="50" cy="72" rx="22" ry="18" />
    <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
    <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
    <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
    <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
  </g>
</svg>
</div>

      <div class="back-row">
        <button class="back-btn" @click="router.back()">
          <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M19 12H5M12 5l-7 7 7 7"/>
          </svg>
          Retour
        </button>
      </div>

      <!-- ══════════════════ MAIN CARD ══════════════════ -->
      <div class="main-card">

        <!-- ── TOP: Image + Détails ── -->
        <div class="card-top">

          <!-- Image col -->
          <div class="img-col">
            <img v-if="post.image" :src="post.image" :alt="post.title" class="hero-img"/>
            <div v-else class="img-placeholder">🐾</div>
            <div class="img-overlay"></div>

            <div class="status-badge" :class="post.status === 'available' ? 'sb-available' : 'sb-adopted'">
              {{ post.status === 'available' ? 'Disponible' : '🏠 Adopté' }}
            </div>

            <div class="img-bottom">
              <div class="type-pills">
                <span v-if="post.isAdoption" class="tpill tpill-gold"> Adoption</span>
                <span v-if="post.isDonation" class="tpill tpill-gold"> Don accepté</span>
              </div>
              <div class="img-category">{{ post.category }}</div>
            </div>
          </div>

          <!-- Details col -->
          <div class="details-col">

            <div class="eyebrow">Publication · Animaux</div>
            <h1 class="detail-title">{{ post.title }}</h1>

            <!-- Meta rows -->
            <div class="meta-grid">
              <div class="meta-item">
                <span class="meta-k"> Ville</span>
                <span class="meta-v">{{ post.city?.replace('_', ' ') }}</span>
              </div>
              <div class="meta-item">
                <span class="meta-k"> Localisation</span>
                <span class="meta-v">{{ post.localisationDetail || '—' }}</span>
              </div>
              <div class="meta-item">
                <span class="meta-k"> Publié par</span>
                <span class="meta-v">{{ post.user?.name }}</span>
              </div>
              <div class="meta-item">
                <span class="meta-k"> Date</span>
                <span class="meta-v">{{ formatDate(post.createdAt) }}</span>
              </div>
            </div>

            <!-- Description -->
            <div class="desc-box">
              <span class="desc-icon">🐾</span>
              <p class="desc-text">{{ post.description }}</p>
            </div>

            <!-- ── Actions ── -->
            <div v-if="authStore.isAuthenticated && post.user?.id !== authStore.user?.id" class="actions-col">

              <!-- Adoption -->
              <div v-if="post.isAdoption && post.status === 'available'" class="action-card ac-adopt">
                <div class="ac-icon blue-icon">
                  <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.8">
                    <path d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z"/>
                  </svg>
                </div>
                <div class="ac-body">
                  <span class="ac-label">Adoption disponible</span>
                  <span class="ac-sub">Prêt à accueillir cet animal ?</span>
                </div>
                <button class="btn-dark" @click="showAdoptionModal = true">Faire une demande →</button>
              </div>

              <!-- Donation -->
              <div v-if="post.isDonation && post.status === 'available'" class="action-card ac-donate">
                <div class="ac-icon gold-icon">
                  <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.8">
                    <line x1="12" y1="1" x2="12" y2="23"/>
                    <path d="M17 5H9.5a3.5 3.5 0 000 7h5a3.5 3.5 0 010 7H6"/>
                  </svg>
                </div>
                <div class="ac-body">
                  <span class="ac-label">Don financier accepté</span>
                  <span class="ac-sub">Un geste peut tout changer.</span>
                </div>
                <button class="btn-outline" @click="showDonationForm = !showDonationForm">
                  {{ showDonationForm ? 'Fermer ↑' : 'Faire un don →' }}
                </button>
              </div>

              <!-- Donation inline form -->
              <transition name="slide">
                <div v-if="showDonationForm && post.isDonation && post.status === 'available'" class="donation-form-box">
                  <div class="dfbox-head">💳 Informations de paiement</div>
                  <div class="donation-grid">
                    <div class="dfield">
                      <label>Numéro de carte</label>
                      <input v-model="donationForm.cardNumber" placeholder="1234 5678 9012 3456" maxlength="16"/>
                    </div>
                    <div class="dfield">
                      <label>Nom sur la carte</label>
                      <input v-model="donationForm.cardHolderName" placeholder="Titulaire"/>
                    </div>
                    <div class="dfield full">
                      <label>Montant (TND)</label>
                      <input v-model.number="donationForm.amount" type="number" placeholder="Ex : 20" min="1"/>
                    </div>
                  </div>
                  <div class="donation-actions">
                    <button class="btn-outline" @click="showDonationForm = false">Annuler</button>
                    <button class="btn-dark" @click="submitDonation" :disabled="donationLoading">
                      {{ donationLoading ? 'Envoi…' : 'Confirmer le don →' }}
                    </button>
                  </div>
                  <div v-if="donationMsg" :class="donationMsg.type === 'success' ? 'alert-success' : 'alert-error'">
                    {{ donationMsg.text }}
                  </div>
                </div>
              </transition>

              <!-- Report -->
              <button class="report-btn" @click="showReportModal = true">
                <svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                  <path d="M10.29 3.86L1.82 18a2 2 0 001.71 3h16.94a2 2 0 001.71-3L13.71 3.86a2 2 0 00-3.42 0z"/>
                  <line x1="12" y1="9" x2="12" y2="13"/>
                  <line x1="12" y1="17" x2="12.01" y2="17"/>
                </svg>
                Signaler ce post
              </button>

            </div>
          </div>
        </div>

        <!-- ── BOTTOM: Comments ── -->
        <div class="comments-section">
          <div class="comments-header">
            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <path d="M21 15a2 2 0 01-2 2H7l-4 4V5a2 2 0 012-2h14a2 2 0 012 2z"/>
            </svg>
            <h3>Commentaires</h3>
            <span class="comment-count">{{ comments.length }}</span>
          </div>

          <div v-if="authStore.isAuthenticated" class="compose-bar">
            <input v-model="newComment" placeholder="Ajouter un commentaire…" @keyup.enter="submitComment"/>
            <button class="btn-dark sm" @click="submitComment">Envoyer</button>
          </div>

          <div class="comment-list">
            <div v-for="comment in comments" :key="comment.id" class="comment-item">
              <div class="c-avatar">{{ comment.user?.name?.[0]?.toUpperCase() }}</div>
              <div class="c-bubble">
                <div class="c-top">
                  <span class="c-name">{{ comment.user?.name }}</span>
                  <span class="c-date">{{ formatDate(comment.created_at) }}</span>
                </div>
                <p class="c-text">{{ comment.content }}</p>
              </div>
            </div>
            <div v-if="comments.length === 0" class="empty-state">
               Soyez le premier à commenter !
            </div>
          </div>
        </div>

      </div><!-- /main-card -->

      <div class="tagline">"Offrez-leur une seconde chance de vivre aimés."</div>

    </div>

    <!-- Loading / not found -->
    <div v-else-if="loading" class="loading-screen">
      <div class="spin-paw">🐾</div>
      <p>Chargement…</p>
    </div>
    <div v-else class="loading-screen"><p>Post non trouvé.</p></div>
  </div>

  <!-- ══════════════════════════════════════
       ADOPTION MODAL
  ══════════════════════════════════════ -->
  <Teleport to="body">
    <Transition name="overlay-fade">
      <div v-if="showAdoptionModal" class="modal-overlay" @click.self="showAdoptionModal = false">
        <Transition name="modal-pop" appear>
          <div class="modal" v-if="showAdoptionModal">
            <div v-if="adoptionSubmitted" class="modal-success">
              <div class="success-blob">✓</div>
              <h2>Votre demande est en cours de traitement !</h2>
              <p>Nous vous contacterons très bientôt. Merci d'ouvrir votre cœur.</p>
              <button class="btn-dark" @click="closeAndResetAdoption">Fermer</button>
            </div>
            <div v-else>
              <div class="modal-header">
                <div class="modal-chip"> Adoption</div>
                <h2 class="modal-title">Votre compagnon<br/>vous attend.</h2>
                <p class="modal-sub">Remplissez le formulaire pour commencer l'aventure.</p>
                <button class="modal-close" @click="showAdoptionModal = false">✕</button>
                <div class="modal-header-deco">🐕</div>
              </div>
              <div class="modal-body">
                <div class="mcard mc-cream">
                  <div class="mcard-head">Informations personnelles</div>
                  <div class="mrow2">
                    <div class="mfield"><label>Nom complet</label><input type="text" v-model="adoptionForm.name" placeholder="Jane Dupont"/></div>
                    <div class="mfield"><label>Téléphone</label><input type="tel" v-model="adoptionForm.phoneNumber" placeholder="+216 00 000 000"/></div>
                  </div>
                  <div class="mfield"><label>Adresse e-mail</label><input type="email" v-model="adoptionForm.email" placeholder="jane@example.com"/></div>
                  <div class="mfield last"><label>Adresse postale</label><input type="text" v-model="adoptionForm.address" placeholder="123 Rue des Animaux, Tunis"/></div>
                </div>
                <div class="mcard mc-peach">
                  <div class="mcard-head"> Votre logement</div>
                  <p class="mcard-desc">Aidez-nous à comprendre l'environnement que votre animal va rejoindre.</p>
                  <div class="mfield">
                    <label>Type de logement</label>
                    <div class="select-wrap">
                      <select v-model="adoptionForm.housingType">
                        <option value="maison">Maison</option>
                        <option value="appartement">Appartement</option>
                        <option value="villa">Villa</option>
                        <option value="autre">Autre</option>
                      </select>
                    </div>
                  </div>
                  <div class="mfield last">
                    <label>Jardin clôturé ?</label>
                    <div class="pill-group">
                      <span class="toggle-pill" :class="{ on: adoptionForm.hasGarden === true }" @click="adoptionForm.hasGarden = true">Oui</span>
                      <span class="toggle-pill" :class="{ on: adoptionForm.hasGarden === false }" @click="adoptionForm.hasGarden = false">Non</span>
                    </div>
                  </div>
                </div>
                <div class="mcard mc-blue">
                  <div class="mcard-head">🐾 Autres animaux</div>
                  <p class="mcard-desc">Avez-vous actuellement d'autres animaux ?</p>
                  <div class="pet-pills">
                    <span v-for="pet in petOptions" :key="pet.value" class="pet-pill" :class="{ on: adoptionForm.pets.includes(pet.value) }" @click="togglePet(pet.value)">{{ pet.label }}</span>
                  </div>
                </div>
                <div class="mfield last">
                  <label>Pourquoi adopter ?</label>
                  <textarea v-model="adoptionForm.message" placeholder="Parlez-nous de votre foyer et de votre cœur…" rows="4"></textarea>
                  <p class="hint"> Votre histoire nous aide à trouver la correspondance parfaite.</p>
                </div>
              </div>
              <div class="modal-footer">
                <p class="modal-quote">"Un animal de compagnie est l'amour inconditionnel à quatre pattes."</p>
                <div class="modal-footer-btns">
                  <button class="btn-outline" @click="showAdoptionModal = false">Annuler</button>
                  <button class="btn-dark" @click="submitAdoption" :disabled="adoptionLoading">
                    {{ adoptionLoading ? 'Envoi en cours…' : 'Soumettre ma candidature →' }}
                  </button>
                </div>
              </div>
            </div>
          </div>
        </Transition>
      </div>
    </Transition>
  </Teleport>

  <!-- ══════════════════════════════════════
       REPORT MODAL
  ══════════════════════════════════════ -->
  <Teleport to="body">
    <Transition name="overlay-fade">
      <div v-if="showReportModal" class="modal-overlay" @click.self="closeReportModal">
        <Transition name="modal-pop" appear>
          <div class="modal report-modal" v-if="showReportModal">
            <div v-if="reportSubmitted" class="modal-success">
              <div class="success-blob">✓</div>
              <h2>Signalement envoyé !</h2>
              <p>Merci pour votre vigilance. Notre équipe va examiner ce post.</p>
              <button class="btn-dark" @click="closeReportModal">Fermer</button>
            </div>
            <div v-else>
              <div class="modal-header report-header">
                <div class="modal-chip report-chip">⚠️ Signalement</div>
                <h2 class="modal-title">Signaler ce post</h2>
                <p class="modal-sub">Dites-nous ce qui ne va pas. Nous prendrons les mesures nécessaires.</p>
                <button class="modal-close" @click="closeReportModal">✕</button>
                <div class="modal-header-deco">🚨</div>
              </div>
              <div class="report-modal-body">
                <div class="report-section">
                  <p class="report-section-label">Choisissez une raison</p>
                  <div class="reason-chips">
                    <span v-for="r in reportReasons" :key="r.value" class="reason-chip"
                      :class="{ on: selectedReason === r.value }" @click="selectedReason = r.value">
                      {{ r.label }}
                    </span>
                  </div>
                </div>
                <div class="report-section">
                  <p class="report-section-label">Détails supplémentaires <span class="optional">(optionnel)</span></p>
                  <textarea v-model="reportReason" placeholder="Décrivez le problème plus en détail…" rows="4" class="report-textarea"></textarea>
                </div>
                <div v-if="reportMsg" class="alert-success" style="margin: 0 1.5rem;">{{ reportMsg }}</div>
              </div>
              <div class="report-modal-footer">
                <button class="btn-outline" @click="closeReportModal">Annuler</button>
                <button class="btn-dark red" @click="submitReport" :disabled="!selectedReason">Envoyer le signalement</button>
              </div>
            </div>
          </div>
        </Transition>
      </div>
    </Transition>
  </Teleport>
</template>

<script setup>
import { ref, onMounted, reactive } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { postsAPI, adoptionAPI, donationsAPI, commentsAPI, reportsAPI } from '../services/api'
import { useAuthStore } from '../stores/authStore'
import NavBar from '../components/NavBar.vue'

const route = useRoute()
const router = useRouter()
const authStore = useAuthStore()

const post = ref(null)
const comments = ref([])
const loading = ref(true)

const showAdoptionModal = ref(false)
const adoptionSubmitted = ref(false)
const adoptionLoading = ref(false)
const adoptionMsg = ref(null)

const showDonationForm = ref(false)
const showReportModal = ref(false)
const reportSubmitted = ref(false)
const selectedReason = ref('')
const donationLoading = ref(false)
const donationMsg = ref(null)
const reportMsg = ref('')
const reportReason = ref('')
const newComment = ref('')

const reportReasons = [
  { value: 'fake',      label: 'Fausse annonce' },
  { value: 'abuse',     label: 'Contenu abusif' },
  { value: 'spam',      label: 'Spam' },
  { value: 'dangerous', label: 'Animal en danger' },
  { value: 'other',     label: 'Autre raison' },
]

const petOptions = [
  { label: '🚫 Aucun',             value: 'none' },
  { label: '🐕 Chiens',            value: 'dogs' },
  { label: '🐱 Chats',             value: 'cats' },
  { label: '🐹 Petits mammifères', value: 'small_mammals' },
]

const adoptionForm = reactive({
  message: '', housingType: 'maison', phoneNumber: '',
  name: '', email: '', address: '',
  hasExperience: false, hasGarden: false, hasChildren: false,
  pets: ['none'],
})

const donationForm = reactive({ cardNumber: '', cardHolderName: '', amount: '' })

const formatDate = (date) => (date ? new Date(date).toLocaleDateString('fr-FR') : '')

const togglePet = (value) => {
  if (value === 'none') { adoptionForm.pets = ['none']; return }
  const idx = adoptionForm.pets.indexOf(value)
  adoptionForm.pets = adoptionForm.pets.filter((p) => p !== 'none')
  if (idx === -1) adoptionForm.pets.push(value)
  else adoptionForm.pets.splice(adoptionForm.pets.indexOf(value), 1)
  if (adoptionForm.pets.length === 0) adoptionForm.pets = ['none']
}

const closeReportModal = () => {
  showReportModal.value = false
  reportSubmitted.value = false
  selectedReason.value = ''
  reportReason.value = ''
  reportMsg.value = ''
}

onMounted(async () => {
  try {
    const [postRes, commentsRes] = await Promise.all([
      postsAPI.getById(route.params.id),
      commentsAPI.getByPost(route.params.id),
    ])
    post.value = postRes.data
    comments.value = commentsRes.data
  } finally {
    loading.value = false
  }
})

const submitAdoption = async () => {
  adoptionLoading.value = true
  adoptionMsg.value = null
  try {
    await adoptionAPI.create({
      postId: Number(route.params.id),
      message: adoptionForm.message,
      housingType: adoptionForm.housingType,
      phoneNumber: adoptionForm.phoneNumber,
      hasExperience: adoptionForm.hasExperience,
      hasGarden: adoptionForm.hasGarden,
      hasChildren: adoptionForm.hasChildren,
    })
    adoptionSubmitted.value = true
  } catch (e) {
    adoptionMsg.value = { type: 'error', text: e.response?.data?.message || 'Erreur lors de la demande' }
  } finally {
    adoptionLoading.value = false
  }
}

const closeAndResetAdoption = () => {
  showAdoptionModal.value = false
  adoptionSubmitted.value = false
  Object.assign(adoptionForm, {
    message: '', housingType: 'maison', phoneNumber: '',
    name: '', email: '', address: '',
    hasExperience: false, hasGarden: false, hasChildren: false,
    pets: ['none'],
  })
}

const submitDonation = async () => {
  donationLoading.value = true
  donationMsg.value = null
  try {
    await donationsAPI.create({
      postId: Number(route.params.id),
      cardNumber: donationForm.cardNumber,
      cardHolderName: donationForm.cardHolderName,
      amount: donationForm.amount,
    })
    donationMsg.value = { type: 'success', text: 'Don effectué avec succès !' }
    showDonationForm.value = false
  } catch (e) {
    donationMsg.value = { type: 'error', text: e.response?.data?.message || 'Erreur lors du don' }
  } finally {
    donationLoading.value = false
  }
}

const submitReport = async () => {
  try {
    const reason = selectedReason.value + (reportReason.value ? ': ' + reportReason.value : '')
    await reportsAPI.create({ postId: Number(route.params.id), reason })
    reportSubmitted.value = true
    reportMsg.value = 'Signalement envoyé !'
  } catch (e) {
    reportMsg.value = e.response?.data?.message || 'Erreur lors du signalement'
  }
}

const submitComment = async () => {
  if (!newComment.value.trim()) return
  try {
    const res = await commentsAPI.create({ postId: Number(route.params.id), content: newComment.value })
    comments.value.unshift(res.data)
    newComment.value = ''
  } catch (e) { console.error(e) }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,700;0,800;1,700&family=DM+Sans:wght@400;500;600&display=swap');

* { box-sizing: border-box; margin: 0; padding: 0; }

/* ─── PAGE ─── */
.page {
  min-height: 100vh;
  font-family: 'DM Sans', sans-serif;
  color: #1a1a2e;
  display: flex;
  flex-direction: column;
}

/* ─── PAGE BACKGROUND AREA ─── */
.page-bg {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem 1.5rem 3.5rem;
  gap: 1rem;
}

/* ─── BACK BUTTON ROW ─── */
.back-row {
  width: 100%;
  max-width: 920px;
}

.back-btn {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  background: #fff;
  border: 1.5px solid #e5dfd0;
  color: #1a1a2e;
  font-size: 0.78rem;
  font-family: inherit;
  font-weight: 600;
  padding: 0.45rem 1rem;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.2s, border-color 0.2s;
}
.back-btn:hover {
  background: #1a1a2e;
  color: #f5d96b;
  border-color: #1a1a2e;
}

/* ─── MAIN CARD ─── */
.main-card {
  width: 100%;
  max-width: 920px;
  background: #fff;
  border-radius: 22px;
  border: 1.5px solid #e5dfd0;
  overflow: hidden;
  box-shadow: 0 8px 40px rgba(26, 26, 46, 0.09);
}

/* ── TOP: Image + Details ── */
.card-top {
  display: grid;
  grid-template-columns: 320px 1fr;
  min-height: 420px;
}

/* IMAGE COLUMN */
.img-col {
  position: relative;
  background: #1a1a2e;
  overflow: hidden;
}
.hero-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
}
.img-placeholder {
  width: 100%;
  height: 100%;
  min-height: 420px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 5rem;
  background: rgba(245, 217, 107, 0.07);
}
.img-overlay {
  position: absolute;
  inset: 0;
  background: linear-gradient(180deg, rgba(26,26,46,0.1) 0%, rgba(26,26,46,0.75) 100%);
}
.status-badge {
  position: absolute;
  top: 14px;
  left: 14px;
  border-radius: 20px;
  font-size: 0.67rem;
  font-weight: 700;
  padding: 0.28rem 0.75rem;
  letter-spacing: 0.04em;
  z-index: 2;
}
.sb-available { background: rgba(40,200,120,0.2); color: #4cde98; border: 1px solid rgba(76,222,152,0.3); }
.sb-adopted   { background: rgba(255,255,255,0.1); color: rgba(255,255,255,0.55); border: 1px solid rgba(255,255,255,0.2); }

.img-bottom {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 1.2rem 1.4rem;
  z-index: 2;
}
.type-pills { display: flex; gap: 6px; flex-wrap: wrap; margin-bottom: 8px; }
.tpill {
  font-size: 0.65rem;
  font-weight: 700;
  padding: 0.22rem 0.65rem;
  border-radius: 20px;
  letter-spacing: 0.03em;
}

.tpill-gold { background: rgba(245,217,107,0.18); color: #f5d96b; border: 1px solid rgba(245,217,107,0.28); }

.img-category {
  font-size: 0.75rem;
  color: rgba(255,255,255,0.45);
  margin-top: 3px;
}

/* DETAILS COLUMN */
.details-col {
  padding: 2rem 2rem 1.8rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  border-left: 1.5px solid #f0ece3;
  overflow-y: auto;
}

.eyebrow {
  font-size: 0.7rem;
  font-weight: 700;
  letter-spacing: 0.14em;
  text-transform: uppercase;
  color: #c8a84b;
}
.detail-title {
  font-family: 'Playfair Display', serif;
  font-size: 1.6rem;
  font-weight: 800;
  color: #1a1a2e;
  line-height: 1.2;
  margin-bottom: 2%;
}

.wavy-line { width: 140px; }
.wavy-line svg { width: 100%; display: block; }

/* Meta grid */
.meta-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 0;
  border: 1.5px solid #f0ece3;
  border-radius: 10px;
  overflow: hidden;
}
.meta-item {
  display: flex;
  flex-direction: column;
  gap: 3px;
  padding: 0.7rem 0.9rem;
  border-bottom: 1px solid #f0ece3;
  border-right: 1px solid #f0ece3;
}
.meta-item:nth-child(2n) { border-right: none; }
.meta-item:nth-last-child(-n+2) { border-bottom: none; }
.meta-k { font-size: 0.68rem; font-weight: 600; color: #aaa; text-transform: uppercase; letter-spacing: 0.04em; }
.meta-v { font-size: 0.82rem; font-weight: 600; color: #1a1a2e; }

/* Description */
.desc-box {
  display: flex;
  gap: 10px;
  align-items: flex-start;
  background: #fafaf8;
  border: 1.5px solid #f0ece3;
  border-radius: 10px;
  padding: 0.9rem 1rem;
}
.desc-icon { font-size: 1.2rem; opacity: 0.6; flex-shrink: 0; margin-top: 2px; }
.desc-text { font-size: 0.85rem; line-height: 1.75; color: #555; }

/* ── Actions ── */
.actions-col {
  display: flex;
  flex-direction: column;
  gap: 0.6rem;
  margin-top: auto;
}

.action-card {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 0.8rem 1rem;
  border-radius: 10px;
  border: 1.5px solid #e8e3d8;
  background: #fff;
  transition: transform 0.15s, box-shadow 0.15s;
}
.action-card:hover { transform: translateY(-1px); box-shadow: 0 4px 16px rgba(26,26,46,0.07); }
.ac-adopt  { border-color: #f5d5a8; background: #fff7ee; }
.ac-donate { border-color: #f5d5a8; background: #fff7ee; }

.ac-icon {
  width: 38px; height: 38px;
  border-radius: 10px;
  display: flex; align-items: center; justify-content: center;
  flex-shrink: 0;
}
.blue-icon { background: #ffffff86; color: #c8a84b; }
.gold-icon { background: rgba(200,168,75,0.15); color: #c8a84b; }

.ac-body { display: flex; flex-direction: column; gap: 2px; flex: 1; }
.ac-label { font-weight: 700; font-size: 0.82rem; color: #1a1a2e; }
.ac-sub   { font-size: 0.7rem; color: #888; }

/* Buttons */
.btn-dark {
  background: #1a1a2e;
  color: #fff;
  border: none;
  padding: 0.55rem 1.1rem;
  border-radius: 8px;
  font-size: 0.8rem;
  font-weight: 600;
  cursor: pointer;
  font-family: inherit;
  white-space: nowrap;
  transition: background 0.2s, transform 0.15s;
}
.btn-dark:hover:not(:disabled) { background: #c8a84b; transform: translateY(-1px); }
.btn-dark:disabled { opacity: 0.6; cursor: not-allowed; }
.btn-dark.sm { padding: 0.42rem 0.85rem; font-size: 0.76rem; border-radius: 8px 15px 15px 8px;}
.btn-dark.red { background: #e05252; }
.btn-dark.red:hover:not(:disabled) { background: #c03030; }

.btn-outline {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  background: #f5f0e8;
  border: none;
  padding: 0.55rem 1rem;
  border-radius: 8px;
  font-size: 0.8rem;
  color: #1a1a2e;
  cursor: pointer;
  font-family: inherit;
  white-space: nowrap;
  transition: background 0.2s;
}
.btn-outline:hover { background: #ede5d0; }

/* Donation form */
.donation-form-box {
  background: #fafaf8;
  border: 1.5px solid #e8e3d8;
  border-radius: 10px;
  padding: 1rem;
  display: flex;
  flex-direction: column;
  gap: 0.8rem;
}
.dfbox-head { font-size: 0.7rem; font-weight: 800; text-transform: uppercase; letter-spacing: 0.08em; color: #888; }
.donation-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 0.6rem; }
.dfield { display: flex; flex-direction: column; gap: 4px; }
.dfield.full { grid-column: 1 / -1; }
.dfield label { font-size: 0.68rem; font-weight: 700; text-transform: uppercase; letter-spacing: 0.04em; color: #999; }
.dfield input {
  padding: 0.55rem 0.8rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 8px;
  font-family: inherit;
  font-size: 0.82rem;
  color: #1a1a2e;
  outline: none;
  transition: border-color 0.2s, box-shadow 0.2s;
}
.dfield input:focus { border-color: #f5d96b; box-shadow: 0 0 0 3px rgba(245,217,107,0.15); }
.donation-actions { display: flex; gap: 0.5rem; justify-content: flex-end; }

/* Report trigger */
.report-btn {
  display: inline-flex;
  align-items: center;
  gap: 5px;
  background: none;
  border: none;
  color: #ccc;
  font-size: 0.75rem;
  font-family: inherit;
  cursor: pointer;
  padding: 0.2rem 0;
  transition: color 0.2s;
  align-self: flex-start;
}
.report-btn:hover { color: #e05252; }

/* Alerts */
.alert-success { padding: 0.55rem 0.8rem; border-radius: 8px; background: #f0faf4; color: #3a9e68; border: 1px solid #c3e6d4; font-size: 0.78rem; }
.alert-error   { padding: 0.55rem 0.8rem; border-radius: 8px; background: #fff0f0; color: #e05252; border: 1px solid #fcd4d4; font-size: 0.78rem; }

/* ── COMMENTS SECTION ── */
.comments-section {
  border-top: 1.5px solid #f0ece3;
  padding: 1.6rem 2rem 2rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  background: #fafaf8;
}

.comments-header {
  display: flex;
  align-items: center;
  gap: 8px;
}
.comments-header svg { color: #c8a84b; }
.comments-header h3 { font-size: 0.95rem; font-weight: 700; color: #1a1a2e; }
.comment-count {
  background: #f0ece3;
  color: #888;
  font-size: 0.7rem;
  font-weight: 700;
  padding: 0.15rem 0.55rem;
  border-radius: 20px;
  margin-left: 2px;
}

.compose-bar {
  display: flex;
  gap: 0.5rem;
  background: #fff;
  border: 1.5px solid #e8e3d8;
  border-radius: 30px;
  padding: 0.28rem 0.28rem 0.28rem 1rem;
  align-items: center;
}
.compose-bar input {
  flex: 1;
  border: none;
  background: transparent;
  font-family: inherit;
  font-size: 0.83rem;
  outline: none;
  color: #1a1a2e;
}
.compose-bar input::placeholder { color: #ccc; }

.comment-list { display: flex; flex-direction: column; gap: 0.65rem; }
.comment-item { display: flex; gap: 0.7rem; align-items: flex-start; }
.c-avatar {
  width: 36px;
  height: 36px;
  background: rgba(200,168,75,0.12);
  border: 2px solid rgba(200,168,75,0.3);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 0.78rem;
  font-weight: 800;
  color: #c8a84b;
  flex-shrink: 0;
}
.c-bubble {
  background: #fff;
  border: 1px solid #e8e3d8;
  border-radius: 0 12px 12px 12px;
  padding: 0.6rem 0.85rem;
  flex: 1;
}
.c-top { display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.2rem; }
.c-name { font-size: 0.76rem; font-weight: 700; color: #1a1a2e; }
.c-date { font-size: 0.67rem; color: #bbb; }
.c-text { font-size: 0.81rem; color: #555; line-height: 1.55; }

.empty-state { text-align: center; padding: 1.5rem; font-size: 0.84rem; color: #aaa; }

/* ─── TAGLINE ─── */
.tagline {
  font-size: 0.75rem;
  color: #b0a898;
  font-style: italic;
  margin-top: 0.5rem;
}

/* ─── LOADING ─── */
.loading-screen {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 60vh;
  gap: 1rem;
  color: #888;
}
.spin-paw { font-size: 3rem; animation: bounce 1.2s ease-in-out infinite; }
@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50%       { transform: translateY(-10px); }
}

/* Slide transition */
.slide-enter-active, .slide-leave-active { transition: all 0.25s ease; }
.slide-enter-from, .slide-leave-to { opacity: 0; transform: translateY(-8px); }

/* ══════════ MODALS ══════════ */
.overlay-fade-enter-active, .overlay-fade-leave-active { transition: opacity 0.25s; }
.overlay-fade-enter-from, .overlay-fade-leave-to { opacity: 0; }
.modal-pop-enter-active { transition: all 0.35s cubic-bezier(0.16, 1.3, 0.3, 1); }
.modal-pop-leave-active { transition: all 0.2s ease; }
.modal-pop-enter-from   { opacity: 0; transform: scale(0.92) translateY(20px); }
.modal-pop-leave-to     { opacity: 0; transform: scale(0.96); }

.modal-overlay {
  position: fixed;
  inset: 0;
  background: rgba(26, 26, 46, 0.52);
  backdrop-filter: blur(5px);
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 1rem;
}
.modal {
  background: #fff;
  border-radius: 22px;
  width: 100%;
  max-width: 600px;
  max-height: 92vh;
  overflow-y: auto;
  box-shadow: 0 40px 100px rgba(26, 26, 46, 0.22);
  font-family: 'DM Sans', sans-serif;
}

/* Modal header */
.modal-header {
  position: relative;
  background: linear-gradient(135deg, #1a1a2e 0%, #2d2d50 100%);
  padding: 2rem 2rem 1.8rem;
  border-radius: 22px 22px 0 0;
  overflow: hidden;
}
.modal-chip {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  background: rgba(245,217,107,0.2);
  color: #f5d96b;
  border: 1px solid rgba(245,217,107,0.35);
  border-radius: 20px;
  padding: 0.28rem 0.8rem;
  font-size: 0.68rem;
  font-weight: 800;
  text-transform: uppercase;
  letter-spacing: 0.06em;
  margin-bottom: 0.75rem;
}
.modal-title {
  font-family: 'Playfair Display', serif;
  font-size: 1.6rem;
  font-weight: 800;
  color: #fff;
  line-height: 1.2;
  margin-bottom: 0.5rem;
}
.modal-sub { font-size: 0.82rem; color: rgba(255,255,255,0.48); }
.modal-close {
  position: absolute;
  top: 14px;
  right: 16px;
  background: rgba(255,255,255,0.1);
  border: none;
  color: rgba(255,255,255,0.6);
  width: 32px;
  height: 32px;
  border-radius: 50%;
  cursor: pointer;
  font-size: 13px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background 0.2s;
}
.modal-close:hover { background: rgba(255,255,255,0.2); color: #fff; }
.modal-header-deco {
  position: absolute;
  right: 2rem;
  bottom: -8px;
  font-size: 4.5rem;
  opacity: 0.1;
  pointer-events: none;
  user-select: none;
}

/* Modal body */
.modal-body { padding: 1.2rem 1.4rem 0; display: flex; flex-direction: column; gap: 0.75rem; }
.mcard { border-radius: 14px; padding: 1rem 1.2rem; }
.mc-cream { background: #fafaf8; border: 1.5px solid #e8e3d8; }
.mc-peach { background: #fde8d8; border: 1.5px solid #f5c9ab; }
.mc-blue  { background: #ddeeff; border: 1.5px solid #b8d6f5; }

.mcard-head { font-size: 0.7rem; font-weight: 800; text-transform: uppercase; letter-spacing: 0.08em; color: #1a1a2e; margin-bottom: 10px; }
.mc-peach .mcard-head { color: #c45c1a; }
.mc-blue  .mcard-head { color: #1a5fa0; }
.mcard-desc { font-size: 0.78rem; color: #888; line-height: 1.5; margin-bottom: 10px; }

.mrow2 { display: grid; grid-template-columns: 1fr 1fr; gap: 10px; }
.mfield { display: flex; flex-direction: column; gap: 4px; margin-bottom: 8px; }
.mfield.last { margin-bottom: 0; }
.mfield label { font-size: 0.68rem; font-weight: 700; text-transform: uppercase; letter-spacing: 0.05em; color: #999; }
.mfield input, .mfield textarea, .mfield select {
  padding: 9px 12px;
  border: 1.5px solid #e8e3d8;
  border-radius: 8px;
  font-family: 'DM Sans', sans-serif;
  font-size: 0.83rem;
  color: #1a1a2e;
  background: #fff;
  outline: none;
  appearance: none;
  width: 100%;
  transition: border-color 0.18s, box-shadow 0.18s;
}
.mfield input:focus, .mfield textarea:focus, .mfield select:focus {
  border-color: #f5d96b;
  box-shadow: 0 0 0 3px rgba(245,217,107,0.15);
}
.mfield textarea { resize: none; min-height: 80px; }

.select-wrap { position: relative; }
.select-wrap select {
  padding-right: 30px;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='7' viewBox='0 0 12 7'%3E%3Cpath d='M1 1l5 5 5-5' stroke='%23999' stroke-width='1.5' fill='none' stroke-linecap='round'/%3E%3C/svg%3E");
  background-repeat: no-repeat;
  background-position: right 10px center;
  cursor: pointer;
}

.pill-group { display: flex; gap: 8px; }
.toggle-pill {
  padding: 7px 18px;
  border: 1.5px solid #e8e3d8;
  border-radius: 30px;
  cursor: pointer;
  font-size: 0.78rem;
  font-weight: 700;
  color: #888;
  background: #fff;
  transition: all 0.15s;
  user-select: none;
}
.toggle-pill.on { background: #1a1a2e; color: #fff; border-color: #1a1a2e; }

.pet-pills { display: flex; flex-wrap: wrap; gap: 7px; }
.pet-pill {
  padding: 6px 14px;
  border: 1.5px solid #b8d6f5;
  border-radius: 30px;
  cursor: pointer;
  font-size: 0.78rem;
  font-weight: 700;
  color: #1a5fa0;
  background: #fff;
  transition: all 0.15s;
  user-select: none;
}
.pet-pill.on { background: #1a5fa0; color: #fff; border-color: #1a5fa0; }

.hint { font-size: 0.72rem; color: #999; margin-top: 7px; }

/* Modal footer */
.modal-footer {
  padding: 1.2rem 1.4rem 1.6rem;
  border-top: 1px solid #f0ebe0;
  margin-top: 0.5rem;
  display: flex;
  flex-direction: column;
  gap: 0.8rem;
}
.modal-quote {
  font-family: 'Playfair Display', serif;
  font-style: italic;
  font-size: 0.78rem;
  color: #bbb;
  text-align: center;
}
.modal-footer-btns { display: flex; justify-content: flex-end; gap: 0.6rem; }


/* Modal success */
.modal-success {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 3.5rem 2rem;
  text-align: center;
  gap: 1rem;
}
.success-blob {
  width: 76px;
  height: 76px;
  border-radius: 50%;
  background: #e8faf0;
  border: 3px solid #3a9e68;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2rem;
  color: #3a9e68;
  animation: popIn 0.4s cubic-bezier(0.16, 1.3, 0.3, 1) both;
}
@keyframes popIn {
  from { transform: scale(0.4); opacity: 0; }
  to   { transform: scale(1); opacity: 1; }
}

/* Paw prints */
.page-bg {
  position: relative;
  overflow: hidden;
}

.paw-prints {
  position: absolute;
  inset: 0;
  pointer-events: none;
  z-index: 0;
}

.paw {
  position: absolute;
  color: #df8a2fe7;
}

/* Positions */
.p1 {
  width: 70px;
  top: 6%;
  left: 3%;
  opacity: 0.1;
  transform: rotate(-20deg);
}

.p2 {
  width: 60px;
  top: 22%;
  right: 5%;
  opacity: 0.07;
  transform: rotate(25deg);
}

.p3 {
  width: 85px;
  top: 48%;
  left: 2%;
  opacity: 0.06;
  transform: rotate(-35deg);
}

.p4 {
  width: 65px;
  bottom: 18%;
  right: 12%;
  opacity: 0.08;
  transform: rotate(18deg);
}

.p5 {
  width: 75px;
  bottom: 6%;
  left: 20%;
  opacity: 0.06;
  transform: rotate(-12deg);
}

.p6 {
  width: 58px;
  top: 72%;
  right: 35%;
  opacity: 0.05;
  transform: rotate(40deg);
}
.p7 {
  width: 90px;
  top: 10%;
  left: 28%;
  opacity: 0.05;
  transform: rotate(32deg);
}

.p8 {
  width: 68px;
  top: 30%;
  right: 22%;
  opacity: 0.07;
  transform: rotate(-28deg);
}

.p9 {
  width: 82px;
  top: 58%;
  left: 30%;
  opacity: 0.05;
  transform: rotate(15deg);
}

.p10 {
  width: 72px;
  bottom: 28%;
  right: 4%;
  opacity: 0.06;
  transform: rotate(-42deg);
}

.p11 {
  width: 62px;
  bottom: 10%;
  left: 48%;
  opacity: 0.05;
  transform: rotate(22deg);
}

.p12 {
  width: 96px;
  top: 82%;
  right: 28%;
  opacity: 0.04;
  transform: rotate(-12deg);
}
/* Keep content above paws */
.back-row,
.main-card,
.tagline {
  position: relative;
  z-index: 2;
}

.modal-success h2 { font-family: 'Playfair Display', serif; font-size: 1.7rem; color: #1a1a2e; }
.modal-success p  { font-size: 0.88rem; color: #888; line-height: 1.6; max-width: 270px; }

/* Report modal */
.report-modal { max-width: 500px; }
.report-header { background: linear-gradient(135deg, #2d1e1e 0%, #4a2020 100%) !important; }
.report-chip {
  background: rgba(224,82,82,0.25) !important;
  color: #f4a0a0 !important;
  border-color: rgba(224,82,82,0.4) !important;
}
.report-modal-body { padding: 1.4rem 1.4rem 0.5rem; display: flex; flex-direction: column; gap: 1.2rem; }
.report-section { display: flex; flex-direction: column; gap: 0.6rem; }
.report-section-label { font-size: 0.72rem; font-weight: 800; text-transform: uppercase; letter-spacing: 0.07em; color: #999; }
.optional { font-weight: 400; text-transform: none; letter-spacing: 0; color: #ccc; }
.reason-chips { display: flex; flex-wrap: wrap; gap: 8px; }
.reason-chip {
  padding: 0.45rem 1rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 30px;
  font-size: 0.8rem;
  font-weight: 700;
  color: #888;
  background: #fff;
  cursor: pointer;
  transition: all 0.15s;
  user-select: none;
}
.reason-chip:hover { border-color: #e05252; color: #e05252; }
.reason-chip.on { background: #ffeaea; color: #c0392b; border-color: #e05252; }
.report-textarea {
  width: 100%;
  padding: 0.75rem 1rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 8px;
  font-family: 'DM Sans', sans-serif;
  font-size: 0.85rem;
  color: #1a1a2e;
  background: #fafaf8;
  outline: none;
  resize: none;
  transition: border-color 0.2s, box-shadow 0.2s;
}
.report-textarea:focus { border-color: #e05252; box-shadow: 0 0 0 3px rgba(224,82,82,0.1); background: #fff; }
.report-modal-footer {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  gap: 0.75rem;
  padding: 1rem 1.4rem 1.4rem;
  border-top: 1px solid #e8e3d8;
  margin-top: 1rem;
}

/* ── Responsive ── */
@media (max-width: 820px) {
  .card-top { grid-template-columns: 1fr; }
  .img-col { min-height: 280px; }
  .details-col { border-left: none; border-top: 1.5px solid #f0ece3; }
  .meta-grid { grid-template-columns: 1fr; }
  .meta-item { border-right: none !important; }
  .meta-item:nth-last-child(-n+2) { border-bottom: 1px solid #f0ece3; }
  .meta-item:last-child { border-bottom: none; }
  .mrow2 { grid-template-columns: 1fr; }
  .donation-grid { grid-template-columns: 1fr; }
  .comments-section { padding: 1.4rem 1.2rem 1.8rem; }
}
@media (max-width: 600px) {
  .page-bg { padding: 1.2rem 0.8rem 2.5rem; }
  .details-col { padding: 1.4rem 1.2rem 1.4rem; }
  .modal-header { padding: 1.5rem 1.2rem 1.3rem; }
  .modal-title  { font-size: 1.3rem; }
}
</style>