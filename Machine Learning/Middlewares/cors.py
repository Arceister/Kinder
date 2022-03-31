from fastapi.middleware import Middleware
from fastapi.middleware.cors import CORSMiddleware

cors_middleware = [
  Middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
  )
]