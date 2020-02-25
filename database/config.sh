#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  CREATE USER hasher WITH PASSWORD 'password';
  ALTER USER hasher WITH SUPERUSER;
  GRANT ALL PRIVILEGES ON DATABASE "splitbill" TO hasher;
EOSQL
