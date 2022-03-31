from fastapi import FastAPI
from Middlewares import cors
from Routers import routes

app = FastAPI(middleware=cors.cors_middleware)

app.include_router(routes.router)
