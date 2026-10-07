<template>
  <div class="page">
    <NavBar />

    <div class="create-wrapper">
      <!-- ── LEFT COLUMN: dark editorial panel ── -->
      <aside class="left-panel">
        <!-- Paw prints background decoration -->
        <div class="paw-prints" aria-hidden="true">
          <svg
            v-for="n in 9"
            :key="n"
            :class="`paw lp${n}`"
            viewBox="0 0 100 100"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g fill="currentColor">
              <ellipse cx="50" cy="72" rx="22" ry="18" />
              <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
              <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
              <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
              <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
            </g>
          </svg>
        </div>

        <!-- Back button -->
        <button class="back-btn" @click="router.back()">
          <svg
            width="16"
            height="16"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
          >
            <path d="M19 12H5M12 5l-7 7 7 7" />
          </svg>
          Retour
        </button>

        <!-- Drop zone -->
        <div
          class="drop-zone"
          :class="{ 'has-image': previewUrl }"
          @dragover.prevent
          @drop.prevent="handleDrop"
          @click="triggerFileInput"
        >
          <img v-if="previewUrl" :src="previewUrl" class="preview-img" alt="Preview" />
          <div v-else class="drop-placeholder">
            <div class="drop-circle">
              <svg
                width="28"
                height="28"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="1.5"
              >
                <rect x="3" y="3" width="18" height="18" rx="3" />
                <circle cx="8.5" cy="8.5" r="1.5" />
                <path d="M21 15l-5-5L5 21" />
              </svg>
            </div>
            <p class="drop-label">Glissez une photo ici</p>
            <span class="drop-sub">ou cliquez pour choisir</span>
          </div>
          <input
            ref="fileInput"
            type="file"
            accept="image/*"
            class="hidden-input"
            @change="handleFileChange"
          />
        </div>

        <!-- URL input -->
        <div class="url-row">
          <span class="url-label">URL</span>
          <input
            v-model="form.image"
            type="url"
            placeholder="https://..."
            class="url-input"
            @input="previewFromUrl"
          />
        </div>

        <!-- Pet stack + tagline -->
        <div class="left-footer">
          <div class="pet-stack">
            <div class="pet-avatar"><img src="@/assets/cat2.jpg" alt="chat" /></div>
            <div class="pet-avatar"><img src="@/assets/cat.jpg" alt="chat" /></div>
            <div class="pet-avatar"><img src="@/assets/chien.jpg" alt="chien" /></div>
          </div>
          <p class="left-tagline">Offrez-leur une seconde chance</p>
        </div>
      </aside>

      <!-- ── RIGHT COLUMN: form ── -->
      <main class="right-panel">
        <!-- Scattered right-side paw prints -->
        <div class="paw-prints-right" aria-hidden="true">
          <svg
            v-for="n in 6"
            :key="n"
            :class="`paw rp${n}`"
            viewBox="0 0 100 100"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g fill="currentColor">
              <ellipse cx="50" cy="72" rx="22" ry="18" />
              <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
              <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
              <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
              <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
            </g>
          </svg>
        </div>

        <form class="form-body" @submit.prevent="handleSubmit">
          <!-- Heading -->
          <div class="form-heading">
            <span class="form-eyebrow">Créez votre publication</span>
            <h1 class="form-title">
              Une nouvelle histoire<br />
              <em>commence ici</em>
            </h1>
          </div>

          <div class="form-grid">
            <!-- Title -->
            <div class="field full">
              <label>Titre <span class="req">*</span></label>
              <input
                v-model="form.title"
                type="text"
                placeholder="Ex : Chaton cherche foyer aimant"
                required
                :disabled="loading"
              />
            </div>

            <!-- Description -->
            <div class="field full">
              <div class="field-header">
                <label>Description <span class="req">*</span></label>
                <span class="char-count">{{ form.description.length }} / 2200</span>
              </div>
              <textarea
                v-model="form.description"
                rows="5"
                placeholder="Décrivez l'animal, son caractère, ses besoins…"
                maxlength="2200"
                required
                :disabled="loading"
              ></textarea>
            </div>

            <div class="rule"></div>

            <!-- Category + City -->
           <!-- Category + City -->
<div class="field half">
  <label>Catégorie <span class="req">*</span></label>
  <div class="autocomplete-wrapper">
    <input
      v-model="form.category"
      type="text"
      placeholder="Chat, Chien, Lapin…"
      required
      :disabled="loading"
      @input="updateCategorySuggestions"
    
      @focus="updateCategorySuggestions"
    />
    <div v-if="categorySuggestions.length > 0" class="autocomplete-dropdown">
      <div 
        v-for="cat in categorySuggestions" 
        :key="cat"
        class="autocomplete-item"
        @mousedown.prevent="form.category = cat; categorySuggestions = []"
      >
        {{ cat }}
      </div>
      <div class="autocomplete-item custom" @mousedown.prevent="categorySuggestions = []">
        Ajouter "{{ form.category }}" comme nouvelle catégorie
      </div>
    </div>
  </div>
  <span class="field-hint">Vous pouvez écrire votre propre catégorie</span>
</div>
            <div class="field half">
              <label>Ville <span class="req">*</span></label>
              <select v-model="form.city" required :disabled="loading">
                <option value="">Sélectionner</option>
                <option v-for="city in cities" :key="city" :value="city">
                  {{ city.replace('_', ' ') }}
                </option>
              </select>
            </div>

            <!-- Location detail -->
            <div class="field full">
              <label>
                <svg
                  width="12"
                  height="12"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  style="vertical-align: middle; margin-right: 4px"
                >
                  <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0118 0z" />
                  <circle cx="12" cy="10" r="3" />
                </svg>
                Localisation détaillée
              </label>
              <input
                v-model="form.localisation_detail"
                placeholder="Quartier, rue…"
                :disabled="loading"
              />
            </div>

            <div class="rule"></div>

            <!-- Story tags -->
            <div class="field full">
              <label>Catégorie d'histoire</label>
              <div class="tags-row">
                <button
                  v-for="tag in storyTags"
                  :key="tag"
                  type="button"
                  class="tag-btn"
                  :class="{ active: selectedTags.includes(tag) }"
                  @click="toggleTag(tag)"
                >
                  {{ tag }}
                </button>
              </div>
            </div>

            <div class="rule"></div>

            <!-- Post options -->
            <div class="field full">
              <label>Options du post</label>
              <div class="options-row">
                <label class="option-card" :class="{ active: form.isAdoption }">
                  <input type="checkbox" v-model="form.isAdoption" />
                  <svg
                    width="15"
                    height="15"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    stroke-width="1.5"
                  >
                    <path
                      d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z"
                    />
                  </svg>
                  <span>Adoption</span>
                </label>
                <label class="option-card" :class="{ active: form.isDonation }">
                  <input type="checkbox" v-model="form.isDonation" />
                  <svg
                    width="15"
                    height="15"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    stroke-width="1.5"
                  >
                    <line x1="12" y1="1" x2="12" y2="23" />
                    <path d="M17 5H9.5a3.5 3.5 0 000 7h5a3.5 3.5 0 010 7H6" />
                  </svg>
                  <span>Dons financiers</span>
                </label>
              </div>
            </div>

            <!-- Donation fields -->
            <transition name="slide">
              <div v-if="form.isDonation" class="field full">
                <div class="donation-grid">
                  <div class="field">
                    <label>Numéro de carte <span class="req">*</span></label>
                    <input
                      v-model="form.cardNumber"
                      placeholder="Pour recevoir les dons"
                      maxlength="16"
                      :disabled="loading"
                    />
                  </div>
                  <div class="field">
                    <label>Nom sur la carte <span class="req">*</span></label>
                    <input
                      v-model="form.cardHolderName"
                      placeholder="Titulaire"
                      :disabled="loading"
                    />
                  </div>
                </div>
              </div>
            </transition>
          </div>

          <!-- Alerts -->
          <div v-if="errorMessage" class="alert alert-error">{{ errorMessage }}</div>
          <div v-if="successMessage" class="alert alert-success">{{ successMessage }}</div>

          <!-- Actions -->
          <div class="form-actions">
            <button type="button" class="btn-draft" @click="saveDraft">
              <svg
                width="14"
                height="14"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
              >
                <path d="M19 21H5a2 2 0 01-2-2V5a2 2 0 012-2h11l5 5v11a2 2 0 01-2 2z" />
                <polyline points="17 21 17 13 7 13 7 21" />
                <polyline points="7 3 7 8 15 8" />
              </svg>
              Brouillon
            </button>
            <button type="submit" class="btn-publish" :disabled="loading">
              {{ loading ? 'Publication…' : 'Publier →' }}
            </button>
          </div>
        </form>
      </main>
    </div>

    <!-- Wave footer -->
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { postsAPI } from '../services/api'
import NavBar from '../components/NavBar.vue'

const router = useRouter()
const loading = ref(false)
const errorMessage = ref('')
const successMessage = ref('')
const fileInput = ref(null)
const previewUrl = ref('')
const selectedFile = ref(null) // Stocke le fichier image

const storyTags = ['#Adoption', '#FosterWin', '#PetTips', '#SuccessStory', '#Urgence', '#Bébé']
const selectedTags = ref([])

const toggleTag = (tag) => {
  const idx = selectedTags.value.indexOf(tag)
  if (idx === -1) selectedTags.value.push(tag)
  else selectedTags.value.splice(idx, 1)
}

const cities = [
  'Tunis', 'Sfax', 'Sousse', 'Kairouan', 'Bizerte', 'Gabes',
  'Ariana', 'Gafsa', 'Monastir', 'Ben_Arous', 'Kasserine',
  'Medenine', 'Nabeul', 'Tataouine', 'Beja', 'Jendouba',
  'El_Kef', 'Mahdia', 'Sidi_Bouzid', 'Siliana', 'Zaghouan',
  'Tozeur', 'Manouba', 'Kebili',
]
/****** pour le categorie autcompilation******** */
// Catégories prédéfinies pour l'autocomplétion
const commonCategories = [
  'Chat', 'Chien', 'Lapin', 'Oiseau', 'Hamster', 'Cochon d\'Inde',
  'Poisson', 'Tortue', 'Furet', 'Rat', 'Souris', 'Cheval',
  'Âne', 'Chèvre', 'Mouton', 'Poule', 'Canard', 'Autre'
]

// Filtrer les suggestions de catégories
const categorySuggestions = ref([])

const updateCategorySuggestions = () => {
  const input = form.category.toLowerCase()
  if (input.length === 0) {
    categorySuggestions.value = []
    return
  }
  categorySuggestions.value = commonCategories.filter(cat => 
    cat.toLowerCase().includes(input)
  ).slice(0, 5) // Limiter à 5 suggestions
}
const form = reactive({
  title: '',
  description: '',
  category: '',
  city: '',
  localisation_detail: '',
  image: '',
  isAdoption: true,
  isDonation: false,
  cardNumber: '',
  cardHolderName: '',
})

const triggerFileInput = () => {
  fileInput.value?.click()
}

// ✅ FIX: compresser l'image avant de la stocker pour éviter le 403 (limite 10MB Tomcat)
const compressImage = (file, maxWidth = 800, quality = 0.75) => {
  return new Promise((resolve) => {
    const reader = new FileReader()
    reader.onload = (event) => {
      const img = new Image()
      img.onload = () => {
        const canvas = document.createElement('canvas')
        let width = img.width
        let height = img.height
        if (width > maxWidth) {
          height = Math.round((height * maxWidth) / width)
          width = maxWidth
        }
        canvas.width = width
        canvas.height = height
        const ctx = canvas.getContext('2d')
        ctx.drawImage(img, 0, 0, width, height)
        resolve(canvas.toDataURL('image/jpeg', quality))
      }
      img.src = event.target.result
    }
    reader.readAsDataURL(file)
  })
}

const handleFileChange = async (e) => {
  const file = e.target.files[0]
  if (file) {
    const compressed = await compressImage(file)
    previewUrl.value = compressed
    form.image = compressed
    selectedFile.value = null
  }
}

const handleDrop = async (e) => {
  const file = e.dataTransfer.files[0]
  if (file) {
    const compressed = await compressImage(file)
    previewUrl.value = compressed
    form.image = compressed
  }
}

const previewFromUrl = () => {
  if (form.image.startsWith('http')) {
    previewUrl.value = form.image
    selectedFile.value = null
  }
}

const saveDraft = () => {
  successMessage.value = 'Brouillon sauvegardé !'
  setTimeout(() => (successMessage.value = ''), 2000)
}

const handleSubmit = async () => {
  errorMessage.value = ''

  if (!form.isAdoption && !form.isDonation) {
    errorMessage.value = 'Le post doit être au moins une adoption ou un don.'
    return
  }

  if (!form.image) {
    errorMessage.value = 'Veuillez ajouter une image'
    return
  }

  loading.value = true

  try {
    const dataToSend = {
      title: form.title,
      description: form.description,
      category: form.category,
      city: form.city,
      localisation_detail: form.localisation_detail,
      image: form.image,
      isAdoption: form.isAdoption,
      isDonation: form.isDonation,
      cardNumber: form.cardNumber || null,
      cardHolderName: form.cardHolderName || null,
    }

    console.log('📤 Envoi (taille image):', Math.round(form.image.length / 1024), 'KB')

    const response = await postsAPI.create(dataToSend)
    successMessage.value = 'Post publié avec succès !'
    setTimeout(() => router.push('/my-posts'), 1500)
  } catch (e) {
    console.error('❌ Erreur complète:', e.response?.status, e.response?.data)
    if (e.response?.status === 403) {
      errorMessage.value = "Accès refusé : vérifiez que vous êtes bien connecté"
    } else if (e.response?.status === 400) {
      errorMessage.value = e.response?.data?.message || "Données invalides"
    } else {
      errorMessage.value = e.response?.data?.message || 'Erreur lors de la publication'
    }
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.page {
  min-height: 100vh;
  background: #fafaf8;
  display: flex;
  flex-direction: column;
  font-family: 'DM Sans', sans-serif;
}
/* Autocomplétion */
.autocomplete-wrapper {
  position: relative;
  width: 100%;
}
.autocomplete-dropdown {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  background: #fff;
  border: 1px solid #e8e3d8;
  border-radius: 8px;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
  z-index: 100;
  max-height: 200px;
  overflow-y: auto;
}
.autocomplete-item {
  padding: 0.6rem 1rem;
  cursor: pointer;
  font-size: 0.85rem;
  transition: background 0.15s;
}
.autocomplete-item:hover {
  background: #f5f0e8;
}
.autocomplete-item.custom {
  border-top: 1px solid #ede9e0;
  color: #c8a84b;
  font-style: italic;
}
.field-hint {
  font-size: 0.7rem;
  color: #aaa;
  margin-top: 4px;
}
.create-wrapper {
  display: grid;
  grid-template-columns: 480px 1fr;
  flex: 1;
  align-items: stretch;
}

.left-panel {
  background: #1a1a2e;
  position: sticky;
  top: 0;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  padding: 2rem 2rem 2.5rem;
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
}

.lp1 {
  width: 66px;
  top: 4%;
  left: 2%;
  color: #f5d96b;
  opacity: 0.12;
  transform: rotate(-18deg);
}
.lp2 {
  width: 50px;
  top: 18%;
  left: 60%;
  color: #f5d96b;
  opacity: 0.08;
  transform: rotate(30deg);
}
.lp3 {
  width: 74px;
  top: 36%;
  left: -2%;
  color: #fff;
  opacity: 0.06;
  transform: rotate(-40deg);
}
.lp4 {
  width: 58px;
  top: 52%;
  left: 70%;
  color: #f5d96b;
  opacity: 0.1;
  transform: rotate(12deg);
}
.lp5 {
  width: 44px;
  top: 68%;
  left: 20%;
  color: #fff;
  opacity: 0.05;
  transform: rotate(55deg);
}
.lp6 {
  width: 62px;
  top: 80%;
  left: 55%;
  color: #f5d96b;
  opacity: 0.09;
  transform: rotate(-25deg);
}
.lp7 {
  width: 48px;
  top: 12%;
  left: 38%;
  color: #fff;
  opacity: 0.06;
  transform: rotate(42deg);
}
.lp8 {
  width: 70px;
  top: 62%;
  left: 8%;
  color: #f5d96b;
  opacity: 0.07;
  transform: rotate(-8deg);
}
.lp9 {
  width: 52px;
  top: 90%;
  left: 80%;
  color: #fff;
  opacity: 0.05;
  transform: rotate(70deg);
}

.back-btn {
  position: relative;
  z-index: 1;
  display: inline-flex;
  align-items: center;
  gap: 6px;
  background: rgba(255, 255, 255, 0.07);
  border: 1px solid rgba(255, 255, 255, 0.12);
  color: #f5d96b;
  font-size: 0.78rem;
  font-family: inherit;
  font-weight: 500;
  padding: 0.45rem 0.9rem;
  border-radius: 6px;
  cursor: pointer;
  align-self: flex-start;
  transition: background 0.2s;
}
.back-btn:hover {
  background: rgba(245, 217, 107, 0.15);
}

/* Drop zone on dark panel */
.drop-zone {
  position: relative;
  z-index: 1;
  flex: 1;
  min-height: 260px;
  max-height: 380px;
  border: 2px dashed rgba(245, 217, 107, 0.3);
  border-radius: 14px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  overflow: hidden;
  background: rgba(255, 255, 255, 0.03);
  transition:
    border-color 0.2s,
    background 0.2s;
}
.drop-zone:hover {
  border-color: #f5d96b;
  background: rgba(245, 217, 107, 0.05);
}
.drop-zone.has-image {
  border-style: solid;
  border-color: rgba(245, 217, 107, 0.4);
  cursor: default;
}
.preview-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.drop-placeholder {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  padding: 2rem;
  text-align: center;
}
.drop-circle {
  width: 56px;
  height: 56px;
  background: rgba(245, 217, 107, 0.12);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #f5d96b;
  margin-bottom: 0.4rem;
}
.drop-label {
  font-size: 0.82rem;
  color: #e8e0d0;
  margin: 0;
  font-weight: 500;
}
.drop-sub {
  font-size: 0.72rem;
  color: rgba(255, 255, 255, 0.3);
}
.hidden-input {
  display: none;
}

/* URL row on dark panel */
.url-row {
  position: relative;
  z-index: 1;
  display: flex;
  align-items: center;
  gap: 8px;
}
.url-label {
  font-size: 0.7rem;
  color: rgba(255, 255, 255, 0.35);
  white-space: nowrap;
  letter-spacing: 0.06em;
  text-transform: uppercase;
}
.url-input {
  flex: 1;
  padding: 0.5rem 0.8rem;
  background: rgba(255, 255, 255, 0.06);
  border: 1px solid rgba(255, 255, 255, 0.12);
  border-radius: 7px;
  font-size: 0.78rem;
  color: #fff;
  font-family: inherit;
  outline: none;
  transition: border-color 0.2s;
}
.url-input::placeholder {
  color: rgba(255, 255, 255, 0.25);
}
.url-input:focus {
  border-color: #f5d96b;
}

/* Left footer */
.left-footer {
  position: relative;
  z-index: 1;
  display: flex;
  align-items: center;
  gap: 12px;
}
.pet-stack {
  display: flex;
}
.pet-avatar {
  width: 38px;
  height: 38px;
  border-radius: 50%;
  overflow: hidden;
  border: 2px solid #1a1a2e;
  margin-left: -8px;
}
.pet-avatar:first-child {
  margin-left: 0;
}
.pet-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.left-tagline {
  font-size: 0.78rem;
  color: rgba(255, 255, 255, 0.45);
  font-style: italic;
  margin: 0;
}

.right-panel {
  position: relative;
  overflow-y: auto;
  background: #fafaf8;
}

.paw-prints-right {
  position: fixed;
  inset: 0;
  pointer-events: none;
  z-index: 0;
}
.rp1 {
  width: 60px;
  top: 8%;
  right: 2%;
  color: #c8a84b;
  opacity: 0.09;
  transform: rotate(20deg);
  animation: pawPulse 9s ease-in-out infinite;
}
.rp2 {
  width: 46px;
  top: 25%;
  right: 18%;
  color: #c8a84b;
  opacity: 0.07;
  transform: rotate(-35deg);
  animation: pawPulse 12s ease-in-out infinite 1.5s;
}
.rp3 {
  width: 70px;
  top: 50%;
  right: 0%;
  color: #c8a84b;
  opacity: 0.08;
  transform: rotate(10deg);
  animation: pawPulse 8s ease-in-out infinite 3s;
}
.rp4 {
  width: 52px;
  top: 72%;
  right: 12%;
  color: #c8a84b;
  opacity: 0.06;
  transform: rotate(-50deg);
  animation: pawPulse 11s ease-in-out infinite 0.8s;
}
.rp5 {
  width: 64px;
  top: 15%;
  right: 38%;
  color: #c8a84b;
  opacity: 0.06;
  transform: rotate(60deg);
  animation: pawPulse 10s ease-in-out infinite 2s;
}
.rp6 {
  width: 44px;
  top: 88%;
  right: 35%;
  color: #c8a84b;
  opacity: 0.07;
  transform: rotate(-15deg);
  animation: pawPulse 7s ease-in-out infinite 4s;
}

/* Form body */
.form-body {
  position: relative;
  z-index: 1;
  max-width: 640px;
  margin: 0 auto;
  padding: 3rem 2.5rem 4rem;
  display: flex;
  flex-direction: column;
  gap: 1.8rem;
}

/* Heading */
.form-eyebrow {
  display: block;
  font-size: 0.72rem;
  font-weight: 700;
  letter-spacing: 0.14em;
  text-transform: uppercase;
  color: #c8a84b;
  margin-bottom: 0.6rem;
}
.form-title {
  font-family: 'Playfair Display', serif;
  font-size: 2rem;
  line-height: 1.25;
  color: #1a1a2e;
  margin: 0 0 0.25rem;
}
.form-title em {
  color: #c8a84b;
  font-style: italic;
}

/* Form grid */
.form-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1rem;
}
.field {
  display: flex;
  flex-direction: column;
  gap: 5px;
}
.field.full {
  grid-column: 1 / -1;
}
.field.half {
  grid-column: span 1;
}

.field label {
  font-size: 0.73rem;
  font-weight: 600;
  color: #1a1a2e;
  letter-spacing: 0.03em;
}
.req {
  color: #c8a84b;
}
.field-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.char-count {
  font-size: 0.7rem;
  color: #bbb;
}

.field input,
.field textarea,
.field select {
  padding: 0.7rem 1rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 10px;
  font-size: 0.85rem;
  font-family: inherit;
  color: #1a1a2e;
  background: #fff;
  outline: none;
  resize: none;
  transition:
    border-color 0.2s,
    box-shadow 0.2s;
}
.field input::placeholder,
.field textarea::placeholder {
  color: #ccc;
}
.field input:focus,
.field textarea:focus,
.field select:focus {
  border-color: #f5d96b;
  box-shadow: 0 0 0 3px rgba(245, 217, 107, 0.15);
}
.field input:disabled,
.field textarea:disabled,
.field select:disabled {
  opacity: 0.5;
}

/* Rule divider */
.rule {
  grid-column: 1 / -1;
  height: 1px;
  background: linear-gradient(90deg, #f0ebe0 0%, transparent 100%);
  margin: 0.3rem 0;
}

/* Tags */
.tags-row {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
  margin-top: 3px;
}
.tag-btn {
  padding: 0.35rem 0.9rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 20px;
  background: #fff;
  font-size: 0.78rem;
  color: #999;
  cursor: pointer;
  font-family: inherit;
  transition: all 0.2s;
}
.tag-btn:hover {
  border-color: #f5d96b;
  color: #c8a84b;
  background: #fffdf0;
}
.tag-btn.active {
  background: #1a1a2e;
  color: #f5d96b;
  border-color: #1a1a2e;
}

/* Options */
.options-row {
  display: flex;
  gap: 0.75rem;
  margin-top: 3px;
}
.option-card {
  flex: 1;
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 0.8rem 1rem;
  border: 1.5px solid #e8e3d8;
  border-radius: 10px;
  cursor: pointer;
  font-size: 0.82rem;
  color: #999;
  user-select: none;
  background: #fff;
  transition: all 0.2s;
}
.option-card input {
  display: none;
}
.option-card:hover {
  border-color: #f5d96b;
  color: #c8a84b;
  background: #fffdf0;
}
.option-card.active {
  border-color: #1a1a2e;
  color: #1a1a2e;
  background: #fffbef;
  font-weight: 600;
}
.option-card svg {
  flex-shrink: 0;
}

/* Donation grid */
.donation-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1rem;
}

/* Slide transition */
.slide-enter-active,
.slide-leave-active {
  transition: all 0.25s ease;
}
.slide-enter-from,
.slide-leave-to {
  opacity: 0;
  transform: translateY(-8px);
}

/* Alerts */
.alert {
  padding: 0.65rem 1rem;
  border-radius: 8px;
  font-size: 0.82rem;
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

/* Actions */
.form-actions {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 10px;
  padding-top: 0.5rem;
  border-top: 1px solid #f0ebe0;
}
.btn-draft {
  display: flex;
  align-items: center;
  gap: 6px;
  background: #f5f0e8;
  border: none;
  padding: 0.6rem 1.2rem;
  border-radius: 8px;
  font-size: 0.82rem;
  color: #1a1a2e;
  cursor: pointer;
  font-family: inherit;
  transition: background 0.2s;
}
.btn-draft:hover {
  background: #ede5d0;
}

.btn-publish {
  background: #1a1a2e;
  color: #fff;
  border: none;
  padding: 0.65rem 1.6rem;
  border-radius: 8px;
  font-size: 0.85rem;
  font-weight: 600;
  cursor: pointer;
  font-family: inherit;
  letter-spacing: 0.02em;
  transition:
    background 0.2s,
    transform 0.15s;
}
.btn-publish:hover:not(:disabled) {
  background: #c8a84b;
  transform: translateY(-1px);
}
.btn-publish:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

/* ── Wave footer ── */
.wave-footer {
  position: relative;
  line-height: 0;
  overflow: visible;
  margin-top: auto;
}
.wave-footer svg {
  display: block;
  width: 100%;
  height: 200px;
}
.wave-dog-left {
  position: absolute;
  left: 0;
  bottom: 0;
  width: 280px;
  height: auto;
  z-index: 10;
}

/* ── Responsive ── */
@media (max-width: 900px) {
  .create-wrapper {
    grid-template-columns: 1fr;
  }
  .left-panel {
    position: relative;
    height: auto;
    min-height: auto;
    padding: 1.5rem;
    gap: 1rem;
  }
  .drop-zone {
    min-height: 200px;
    max-height: 260px;
  }
  .form-body {
    padding: 2rem 1.5rem 3rem;
  }
  .form-grid {
    grid-template-columns: 1fr;
  }
  .field.half {
    grid-column: 1 / -1;
  }
  .paw-prints-right {
    display: none;
  }
}
</style>